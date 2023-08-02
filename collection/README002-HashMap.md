HashMap
=
# 1.成员变量
~~~ java
// 默认容量
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

// 最大容量
static final int MAXIMUM_CAPACITY = 1 << 30;

// 负载因子
static final float DEFAULT_LOAD_FACTOR = 0.75f;

// 默认树化的阈值
static final int TREEIFY_THRESHOLD = 8;

// 非树化的阈值
static final int UNTREEIFY_THRESHOLD = 6;

// 树化的最小容量
static final int MIN_TREEIFY_CAPACITY = 64;

// 用数组存储数据散列表
transient Node<K,V>[] table;

// 当前负载因子
final float loadFactor;

// 结点定义
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
~~~
# 2.主要的构造器
~~~ java
public HashMap(int initialCapacity, float loadFactor) {
	// 对传入初始化容量的边界判断
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);
    this.loadFactor = loadFactor;
    
    // 这个tableSizeFor()方法。
    // 确保返回的容量大小是大于等于给定参数的最小的 2 的幂次方的值
    this.threshold = tableSizeFor(initialCapacity);
}
~~~


# 3.put核心
获取hashcode
~~~ java
static final int hash(Object key) {// 使高位低位都参与运算
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
~~~
核心
~~~ java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
    Node<K,V>[] tab;
    Node<K,V> p; 
    int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)// 把table（散列数组）赋给tab，如果length==0，则扩容
        n = (tab = resize()).length;// resize扩容
    if ((p = tab[i = (n - 1) & hash]) == null)// 取一个下标赋给p，如果取的下标在散列数组中是空值
        tab[i] = newNode(hash, key, value, null);// new一个Node放进去
    else {// 该下标已存在，就要挂到链表尾部
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))// 先比较hash，再比较key值，如果都一样，就覆盖
            e = p;
        else if (p instanceof TreeNode)// 树形结点
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {// 往链表尾插
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);// 树化
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))// 比较头结点之后的是否有相同key
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold) // 添加结点之后比阈值大时，扩容
        resize();
    afterNodeInsertion(evict);
    return null;
}
~~~
扩容
~~~ java
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {// 有数据，需要扩容
        if (oldCap >= MAXIMUM_CAPACITY) {// 到达最大容量
            threshold = Integer.MAX_VALUE;// 直接给最大值
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)// 小于最大容量，扩容两倍
            newThr = oldThr << 1; // 阈值也×2
    }
    else if (oldThr > 0) // 有参构造，在构造时传入初始化容量
        newCap = oldThr;// 旧阈值给新容量
    else {               // 无参构造
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {// 有参构造时计算阈值
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    
    if (oldTab != null) {// 重新装填散列表
        ...
    }
    return newTab;
}
~~~

ConCurrentHashMap
=
加了分段锁，锁表头
~~~ java
final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) throw new NullPointerException();
    int hash = spread(key.hashCode());
    int binCount = 0;
    for (Node<K,V>[] tab = table;;) {
        Node<K,V> f; int n, i, fh;
        if (tab == null || (n = tab.length) == 0)
            tab = initTable();
        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
            if (casTabAt(tab, i, null,
                         new Node<K,V>(hash, key, value, null)))
                break;                   // no lock when adding to empty bin
        }
        else if ((fh = f.hash) == MOVED)
            tab = helpTransfer(tab, f);
        else {
            V oldVal = null;
            synchronized (f) {
                if (tabAt(tab, i) == f) {
                    if (fh >= 0) {
                        binCount = 1;
                        for (Node<K,V> e = f;; ++binCount) {
                            K ek;
                            if (e.hash == hash &&
                                ((ek = e.key) == key ||
                                 (ek != null && key.equals(ek)))) {
                                oldVal = e.val;
                                if (!onlyIfAbsent)
                                    e.val = value;
                                break;
                            }
                            Node<K,V> pred = e;
                            if ((e = e.next) == null) {
                                pred.next = new Node<K,V>(hash, key,
                                                          value, null);
                                break;
                            }
                        }
                    }
                    else if (f instanceof TreeBin) {
                        Node<K,V> p;
                        binCount = 2;
                        if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                       value)) != null) {
                            oldVal = p.val;
                            if (!onlyIfAbsent)
                                p.val = value;
                        }
                    }
                }
            }
            if (binCount != 0) {
                if (binCount >= TREEIFY_THRESHOLD)
                    treeifyBin(tab, i);
                if (oldVal != null)
                    return oldVal;
                break;
            }
        }
    }
    addCount(1L, binCount);
    return null;
}
~~~