package MetaProgram

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

data class Person(val name: String, val age: Int, var address: String) {
    fun friendsName(): List<String> {
        return listOf("Yison", "Jilen")
    }

    fun <A> get(a: A): A {
        return a
    }
}

fun KMutablePropertyShow() {
    val p = Person("极跑科技", 8, "HangZhou")
    val props = p::class.memberProperties
    for (prop in props) {
        when (prop) {
            is KMutableProperty<*> -> prop.setter.call(p, "Hefei")
            else -> prop.call(p)
        }
    }
    println(p.address)
}

//KParameter
fun KParameterShow() {
    val p = Person("极跑科技", 8, "hangzhou")
    for (c in Person::class.members) {
        print("${c.name} ->")
        for (p in c.parameters) {
            print("${p.type}" + "--")
        }
        println()
    }
}

fun KTypeParameterShow() {
    for (c in Person::class.members) {
        if (c.name.equals("get")) {
            println(c.typeParameters)
        }
    }
    val list = listOf<String>("How")
    println(list::class.typeParameters)
}

fun main(args: Array<String>) {
    KMutablePropertyShow()
    println()
    KParameterShow()
    println()

    //KType
    Person::class.members.forEach {
        println("${it.name}->${it.returnType.classifier}")
    }
    println()

    KTypeParameterShow()
    println()
}