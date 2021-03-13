package Extensions

data class Area(val value:Double)
operator fun Area.plus(that:Area):Area{
    return Area(this.value+that.value)
}
fun main(args: Array<String>) {
    println(Area(1.0)+Area(2.0))
    println(Area(3.0)+Area(7.0))
}