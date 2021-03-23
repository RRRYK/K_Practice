package DesignPatterns

data class Book(val name: String)

//实现Iterator接口
class Bookcase(val books: List<Book>) : Iterator<Book> {
    private val iterator: Iterator<Book>

    init {
        this.iterator = books.iterator()
    }

    override fun hasNext() = this.iterator.hasNext()
    override fun next() = this.iterator.next()
}

//重载Iterator方法
class Bookcase1(val books: List<Book>) {
    operator fun iterator(): Iterator<Book> = this.books.iterator()
}

//通过扩展函数
class Bookcase2(val books:List<Book>){}
operator fun Bookcase2.iterator():Iterator<Book> = books.iterator()

fun main(args: Array<String>) {
    val bookcase = Bookcase(
            listOf(Book("Dive into Kotlin"), Book("Thinking in Java"))
    )
    while (bookcase.hasNext()) {
        println("Thr book is ${bookcase.next().name}")
    }

    val bookcase1 = Bookcase(
            listOf(Book("Dive into Kotlin"), Book("Thinking in Java"))
    )
    while (bookcase1.hasNext()) {
        println("Thr book is ${bookcase1.next().name}")
    }

    val bookcase2 = Bookcase(
            listOf(Book("Dive into Kotlin"), Book("Thinking in Java"))
    )
    while (bookcase2.hasNext()) {
        println("Thr book is ${bookcase2.next().name}")
    }
}