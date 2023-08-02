迭代器
=
# 1.List
~~~ java
List<int> ints new ArrayList<>(){
	// 可在定义时重写方法
};
Iterator<int> iterator = ints.iterator();// 交给迭代器
while(iterator.hasNext()){
	int next = iterator.next();// 拿到下一个
	...
}
~~~

# 2.hashMap
第一种迭代方式
~~~ java
Set<Integer> integers = hashmap.keySet();// 拿到key集合
Iterator<Integer> iterator = integers.iterator();
while (iterator.hasNext()) {// 用key遍历
    Integer key = iterator.next();
    System.out.println("key = " + key);
    System.out.println("value = " + hashmap.get(key));
}
~~~
第二种
~~~ java
Set<Map.Entry<Integer, Integer>> entries = hashmap.entrySet();
Iterator<Map.Entry<Integer, Integer>> iterator1 = entries.iterator();

while (iterator1.hasNext()) {//错误做法，一次循环里调了两次next
    System.out.println("key = " + iterator1.next().getKey());
    System.out.println("value = " + iterator1.next().getValue());
}

while (iterator1.hasNext()) {//正确的
    Map.Entry<Integer, Integer> next = iterator1.next();// 先拿出来
    System.out.println("key = " + next.getKey());
    System.out.println("value = " + next.getValue());
}
~~~
第二种效率高，因为第一种每次get(key)之后还会在map里再找一遍。<br>第二种是直接遍历一次map后放到entrySet里，只需遍历entrySet里的即可
# 3.使用迭代器删除元素
1.回调指针<br>
2.逆序遍历<br>
3.使用迭代器
~~~ java
Iterator<String> iterator = names.iterator();
while (iterator.hasNext()){
    // next(),只能调用一次，因为每次调用都会选择下一个
    String name = iterator.next();
    if("lucy".equals(name)){
        iterator.remove();
    }
}
~~~