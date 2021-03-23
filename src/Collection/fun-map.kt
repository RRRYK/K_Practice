package Collection

//map方法：接收一个函数，这个函数对集合中的每个元素进行操作，
// 然后将操作后的结果返回，最后产生一个有这些结果组成的新集合
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6)
    println(list)
    val newList = list.map { a -> a * 2 }
    println(newList)
}