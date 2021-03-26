package DesignPatterns

/*
装饰者模式：在不必改变原类未年检和使用继承的情况下，动态地扩展一个对象的功能。该模式通过创建一个包装对象，来包裹真实的对象
 */

interface Macbook {
    fun getCost(): Int
    fun getDesc(): String
    fun getPeodDate(): String
}

class MacBookPro : Macbook {
    override fun getCost() = 10000
    override fun getDesc() = "Macbook Pro"
    override fun getPeodDate() = "Late 2011"
}

class ProcessorUpgradeNacbookPro(val macbook: Macbook) : Macbook by macbook {
    override fun getCost() = macbook.getCost() + 219
    override fun getDesc() = macbook.getDesc() + ", +1G Memory"
}

class Printer{
    fun drawLine(){
        println("---------")
    }
    fun drawDottedLine(){
        println("- - - - - ")
    }
    fun drawStars(){
        println("********")
    }
}
//通过扩展代替装饰者
fun Printer.startDraw(decorated:Printer.() -> Unit) {
    println("+++ start drawing +++")
    this.decorated()
    println("+++ end frawing +++")
}

fun main(args: Array<String>) {
    val macBookPro = MacBookPro()
    val processorUpgradeNacbookPro = ProcessorUpgradeNacbookPro(macBookPro)
    println(processorUpgradeNacbookPro.getCost())
    println(processorUpgradeNacbookPro.getDesc())

    Printer().run {
        startDraw {
            drawLine()
        }
        startDraw {
            drawDottedLine()
        }
        startDraw {
            drawStars()
        }
    }

}