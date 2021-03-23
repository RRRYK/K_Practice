package MetaProgram

sealed class Nat {
    companion object {
        object Zero : Nat()
    }

    val Companion._0
        get() = Zero

    fun <A : Nat> Succ<A>.preceed(): A {
        return this.prev
    }
}

data class Succ<N : Nat>(val prev: N) : Nat()

fun <A : Nat> Nat.plus(other: A): Nat = when {
    other is Succ<*> -> Succ(this.plus(other.prev)) //a+S(b) =S(a+b)
    else -> this
}

