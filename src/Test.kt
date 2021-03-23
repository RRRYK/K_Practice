interface flyer {
    fun fly()
    fun kind() = "[flyer] flying animals"
}

interface animals {
    val name: String
    fun eat()
    fun kind() = "[animals] flying animals"
}

class Bird(override val name: String) : flyer, animals {
    override fun eat() {
        println("I can eat")
    }

    override fun fly() {
        println("I can fly")
    }

    override fun kind() = "a flying ${this.name}"
}

fun main(args: Array<String>) {
    val bird = Bird("sparrow")
    println(bird.kind())
    fun pattern(s: Int) = when (s) {
        3 -> println("aaa")
        4 -> println("bbb")
        else -> println("ccc")
    }
    pattern(9)

    println("f" in "a".."z")
    var string = """eow\ndsghajgj"""
    println(string)
}