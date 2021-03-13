package VarAndVal

//变量取值范围
fun main() {
    val aByte:Byte=Byte.MAX_VALUE
    val bByte:Byte= Byte.MIN_VALUE
    println("Byte最大值"+aByte)
    println("Byte最小值"+bByte)
    val aLong:Long=Long.MAX_VALUE
    val bLong:Long=Long.MIN_VALUE
    println("Byte最大值"+aLong)
    println("Byte最小值"+bLong)

    val aInt:Int=0b0011
    println(aInt)
}