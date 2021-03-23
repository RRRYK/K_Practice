package DesignPatterns

//策略模式
interface SwimStrategy {
    fun swim()
}

class Breaststroke : SwimStrategy {
    override fun swim() {
        println("I am breaststroking...")
    }
}

class Backstroke : SwimStrategy {
    override fun swim() {
        println("I am backstroking...")
    }
}

class Freestyle : SwimStrategy {
    override fun swim() {
        println("I am freestyling...")
    }
}

class Swimmer(val strategy: SwimStrategy) {
    fun swim() {
        strategy.swim()
    }
}

//高阶函数抽象算法
fun breaststroke() {
    println("I am breaststroking...")
}

fun backstroke() {
    println("I am backstroking...")
}

fun freestyle() {
    println("I am freestyling...")
}

class Swimmer1(val swimming: () -> Unit) {
    fun swim() {
        swimming()
    }
}

fun main(args: Array<String>) {
    val weekendShaw = Swimmer(Freestyle())
    weekendShaw.swim()
    val weekdaysShaw = Swimmer(Breaststroke())
    weekdaysShaw.swim()

    val weekendShaw1 = Swimmer1(::freestyle)
    weekendShaw1.swim()
    val weekdaysShaw1 = Swimmer1(::breaststroke)
    weekdaysShaw1.swim()
}

