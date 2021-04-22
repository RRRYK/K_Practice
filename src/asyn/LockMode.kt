package asyn

class Shop {
    val goods = hashMapOf<Long, Int>()

    init {
        goods.put(1, 10)
        goods.put(2, 15)
    }

    @Synchronized
    fun buyGoods(id: Long) {
        val stock = goods.getValue(id)
        goods.put(id, stock - 1)
    }

    fun buyGoods2(id: Long) {
        synchronized(this) {
            val stock = goods.getValue(id)
            goods.put(id, stock - 1)
        }
    }

}

fun main(args: Array<String>) {
    val a=Shop()
    a.buyGoods(1)
    a.buyGoods(1)
    a.buyGoods2(2)
    a.buyGoods2(2)
    a.buyGoods2(2)
    println(a.goods)
}