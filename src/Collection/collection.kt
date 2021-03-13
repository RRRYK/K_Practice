package Collection

fun main(args: Array<String>) {
    val list=listOf(1,2,3,4,4,5,5)
    //List表示一个有序的可重复的列表
    println(list)

    val set=setOf(1,2,3,4,4,5,5)
    //set表示一个不可重复的集合，具体实现：HashSet和TreeSet
    //HashSet用Hash散列表存放数据，不能保证元素的有序性
    //TreeSet底层结构式是二叉树能保证元素的有序性
    println(set)

    val map=mapOf(1 to 1,2 to 2,3 to 3)
    //map用来表示键值对元素集合，其中键值对不能重复
    println(map)

    //mutable 可变集合
    val mlist = mutableListOf(1,2,3,4,5)
    println(mlist)
    mlist[0]=0
    println(mlist)

    //只读集合
    val list1=listOf(1,2,3,4,5)
    println(list1)

    val list2 = listOf(1,2,3,4,5)
    println(list2.filter{it>2}.map{it*2})
    println(list.asSequence().filter{it>2}.map{it*2}.toList())
    //asSequence()方法将一个列表转化为序列，然后在这个序列上进行相应的操作
    //最后通过toList()方法将序列转化为列表




}