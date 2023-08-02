List
=
# 1.ArrayList
成员变量
~~~ java
// 序列化
private static final long serialVersionUID = 8683452581122892189L;

// 初始化容量
private static final int DEFAULT_CAPACITY = 10;

// 空数组，有参构造时使用
private static final Object[] EMPTY_ELEMENTDATA = {};

// 空数组，无参构造时使用
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

// 实际数组，transient是忽略序列化
transient Object[] elementData; 

// 大小
private int size;
~~~
***
构造器
~~~ java
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}

public ArrayList() {// 空参使用默认空数组，直接把扩容的过程省略了
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}

// 直接传一个集合
public ArrayList(Collection<? extends E> c) {
    Object[] a = c.toArray();
    if ((size = a.length) != 0) {// 有数据就拷贝
        if (c.getClass() == ArrayList.class) {
            elementData = a;
        } else {
            elementData = Arrays.copyOf(a, size, Object[].class);
        }
    } else {
        // replace with empty array.
        elementData = EMPTY_ELEMENTDATA;
    }
}
~~~
扩容 grow()方法
~~~ java
private void grow(int minCapacity) {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);// 新容量是旧的1.5倍
    // 边界判断
    if (newCapacity - minCapacity < 0)// 新容量小于扩容所需的最小容量。这种情况只有当oldCapacity = 1时出现，因为1左移1是0。扩容了屁
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)// 大于Integer最大表示范围（不直接判断因为可能会溢出）
        newCapacity = hugeCapacity(minCapacity);
    // 整体拷贝，指向新引用
    elementData = Arrays.copyOf(elementData, newCapacity);
}

private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
}
~~~
***
# 2.LinkedList（双向链表）
成员变量
~~~ java
// 长度
transient int size = 0;

// 头结点
transient Node<E> first;

// 尾结点
transient Node<E> last;

// 结点类
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
~~~
插入
~~~ java
// 头插
private void linkFirst(E e) {
    final Node<E> f = first;
    final Node<E> newNode = new Node<>(null, e, f);
    first = newNode;
    if (f == null)
        last = newNode;
    else
        f.prev = newNode;
    size++;
    modCount++; // 并发修改相关的变量
}

// 尾插
void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}
~~~
add()默认使用尾插
~~~
public boolean add(E e) {
    linkLast(e);
    return true;
}
~~~





























































