package DesignPatterns

import java.lang.IllegalArgumentException

interface Computer1
class Dell:Computer1
class Asus:Computer1
class Acer:Computer1

class DellFactory:AbstractFactory(){
    override fun produce()=Dell()
}

class AsusFactory:AbstractFactory(){
    override fun produce()=Asus()
}

class AcerFactory:AbstractFactory(){
    override fun produce()=Acer()
}
abstract class AbstractFactory{
    abstract fun produce(): Computer1

    //抽象工厂模式
//    companion object{
//        operator fun invoke(factory:AbstractFactory):AbstractFactory{
//            return factory
//        }
//    }

    //重新实现invoke方法
    companion object{
        inline operator fun <reified T: Computer1> invoke():AbstractFactory=
                when(T::class){
                    Dell::class->DellFactory()
                    Asus::class->AsusFactory()
                    Acer::class->AcerFactory()
                    else->throw IllegalArgumentException()
                }
    }
}

fun main(args: Array<String>) {
    //抽象工厂模式
    //val dellFactory=AbstractFactory(DellFactory())

    //重新实现invoke方法
    val dellFactory=AbstractFactory<Dell>()

    val dell= dellFactory.produce()
    println(dell)
}