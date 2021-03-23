package Collection

import java.util.stream.Stream

data class Student(val name: String, val age: Int, val sex: String, val score: Int, val hobbies: List<String>)

val jilen = Student("Jilen", 30, "m", 85, listOf("coding", "reading"))
val shaw = Student("Shaw", 18, "m", 90, listOf("dringing", "fishing"))
val yison = Student("Yison", 40, "f", 59, listOf("running", "game"))
val jack = Student("Jack", 40, "m", 70, listOf("drawing"))
val lisa = Student("Lisa", 25, "m", 88, listOf("writing"))
val pan = Student("Pan", 36, "f", 55, listOf("dancing"))
val students = listOf(jilen, shaw, yison, jack, lisa, pan)

fun main() {
    val mStudnets = students.filter { it.sex == "m" }
    //filter接收一个函数返回类型为Boolean，判断集合中每一项是否满足某个条件，如果满足插入新列表，最终返回新列表
    println(mStudnets)

    val fStudents = students.filterNot { it.sex == "m" }
    //filterNot与filter作用相反
    println(fStudents)

    //filterNotNull,用来过滤掉值为null的元素

    val countMStudents = students.count { it.sex == "m" }
    //val countMStudents= students.filter{it.sex=="m"}.size
    println(countMStudents)

    val countFStudents = students.count { it.sex == "f" }
    //val countMStudents= students.filter{it.sex=="f"}.size
    //count统计满足条件的元素的个数
    println(countFStudents)

    val scoreTotal = students.sumBy { it.score }//sumBy对集合进行求和操作
    println(scoreTotal)

    val a = listOf(1, 2, 3, 4, 5)
    val aTotal_sum = a.sum() //sum对数值类型的列表进行求和
    val aTotal_sumBy = a.sumBy { it }
    println(aTotal_sum)
    println(aTotal_sumBy)

    val aTotal_fold = students.fold(0) { accumulator, student -> accumulator + student.score }
    println(aTotal_fold)

//    val scoreTotal_reduce=students.reduce{accumulator,student->accumulator+student.score}
//    println(scoreTotal_reduce)
    //存在异常

    println(students.groupBy { it.sex })//groupBy分组之后集合是一个Map

    val list = listOf(listOf(jilen, shaw, lisa), listOf(yison, pan), listOf(jack))
    println(list.flatten())//flatten扁平化————处理嵌套集合

    println(list.flatMap { it.map { it.name } })//flatMap————返回一个加工过之后的集合
    //println(list.flatten().map{it.name})

    println(students.map { it.hobbies }.flatten())
    println(students.flatMap { it.hobbies })


}