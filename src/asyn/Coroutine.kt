package asyn

import kotlinx.coroutines.*

suspend fun searchItemOne(): String {
    delay(500L)
    return "item-one"
}

suspend fun searchItemTwo(): String {
    delay(500L)
    return "item-two"
}

fun main() = runBlocking {    //最高级的协程，主协程

    GlobalScope.launch {
        delay(500L)
        println("World!")
    }
    println("Hello,")
    delay(1000L)

    val job = launch {
        search()
    }
    println("Hello,")
    job.join()

    //使用async相当于创建了一个子协程，会返回一个Deferred对象
    //(Deferred值是一个非阻塞可取消的future，它是一个带有结果的job)
    val one = async { searchItemOne() }
    val two = async { searchItemTwo() }
    println("The items is ${one.await()} and ${two.await()}")
}

suspend fun search() {
    delay(500L)
    println("World!")
}