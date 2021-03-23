package DesignPatterns

interface Computer {
    val cpu: String

    //伴生对象
//    companion object{
//        operator fun invoke(type:ComputerType):Computer{
//            return when (type){
//                ComputerType.PC->PC()
//                ComputerType.Server->Server()
//            }
//        }
//    }
    companion object Factory {
        operator fun invoke(type: ComputerType): Computer {
            return when (type) {
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}

//扩展Factory伴生对象方法
fun Computer.Factory.fromcpu(cpu: String): ComputerType? = when (cpu) {
    "Core" -> ComputerType.PC
    "Xeon" -> ComputerType.Server
    else -> null
}

class PC(override val cpu: String = "Core") : Computer
class Server(override val cpu: String = "Xeon") : Computer

enum class ComputerType {
    PC, Server
}

//工厂类
class ComputerFactory1 {
    fun produce(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

//单例
object ComputerFactory2 {
    fun produce(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

//重载invoke方法
object ComputerFactory3 {
    operator fun invoke(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

fun main(args: Array<String>) {
    //工厂模式创建类
    val comp1 = ComputerFactory1().produce(ComputerType.PC)
    println(comp1.cpu)

    //单例创建类
    val comp2 = ComputerFactory2.produce(ComputerType.Server)
    println(comp2.cpu)

    //重载invoke方法
    val comp3 = ComputerFactory3(ComputerType.PC)
    println(comp3.cpu)

    //Computer接口定义伴生对象
//    val comp4=Computer(ComputerType.Server)//Computer调用伴生对象方法
//    println(comp4.cpu)

    //Computer接口定义Factory伴生对象
    val comp5 = Computer.Factory(ComputerType.Server)//Factory命名伴生对象
    println(comp5.cpu)

    println(Computer.Factory.fromcpu(comp1.cpu))

}