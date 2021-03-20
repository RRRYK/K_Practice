package MetaProgram

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

data class Person (val name:String ,val age:Int ,var address:String)
fun KMutablePropertyShow(){
    val p=Person("极跑科技",8,"HangZhou")
    val props=p::class.memberProperties
    for (prop in props){
        when(prop){
            is KMutableProperty<*> -> prop.setter.call(p,"Hefei")
            else ->prop.call(p)
        }
    }
    println(p.address)
}

fun main(args: Array<String>) {
    KMutablePropertyShow()
}