package DesignPatterns

/*
观察者模式：观察者模式定义了一个一对多的依赖关系，让一个或多个观察者对象监听一个主题对象。
这样以来，当被观察者状态发生改变时，需要通知相应的观察者，使这些观察者对象能够自动更新
 */
import kotlin.properties.Delegates

interface StockUpdateListener {
    fun onRise(price: Int)
    fun onFall(price: Int)
}

class StockUpdate {
    var listener = mutableSetOf<StockUpdateListener>()
    var price: Int by Delegates.observable(0) { _, old, new ->
        listener.forEach {
            if (new > old) it.onRise(price) else it.onFall(price)
        }
    }
}

class StockDisplay : StockUpdateListener {
    override fun onRise(price: Int) {
        println("The latest stock price has risen to ${price}.")
    }

    override fun onFall(price: Int) {
        println("The latest stock price has fell to ${price}.")
    }
}

fun main(args: Array<String>) {
    val su = StockUpdate()
    val sd = StockDisplay()
    su.listener.add(sd)
    su.price = 100
    su.price = 98
}