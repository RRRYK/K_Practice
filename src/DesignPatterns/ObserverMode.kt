package DesignPatterns
import kotlin.properties.Delegates

interface StockUpdateListener{
    fun onRise(price:Int)
    fun onFall(price:Int)
}

class StockUpdate{
    var listener= mutableSetOf<StockUpdateListener>()
    var price:Int by Delegates.observable(0){_,old,new->
        listener.forEach {
            if(new>old)it.onRise(price) else it.onFall(price)
        }
    }
}

class StockDisplay:StockUpdateListener{
    override fun onRise(price: Int) {
        println("The latest stock price has risen to ${price}.")
    }

    override fun onFall(price: Int) {
        println("The latest stock price has fell to ${price}.")
    }
}

fun main(args: Array<String>) {
    val su=StockUpdate()
    val sd=StockDisplay()
    su.listener.add(sd)
    su.price=100
    su.price=98
}