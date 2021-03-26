package DesignPatterns

/*
状态模式允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类
 */

sealed class WaterMachineState(open val machine: WaterMachine) {
    fun turnHeating() {
        if (this !is Heating) {
            println("turn Heating")
            machine.state = machine.heating
        } else {
            println("The state is already heating mode.")
        }
    }

    fun turnCooling() {
        if (this !is Cooling) {
            println("turn cooling")
            machine.state = machine.cooling
        } else {
            println("The state is already cooling mode.")
        }
    }

    fun turnOff() {
        if (this !is Off) {
            println("turn off")
            machine.state = machine.off
        } else {
            println("The state is already off.")
        }
    }
}

class Off(override val machine: WaterMachine) : WaterMachineState(machine)
class Heating(override val machine: WaterMachine) : WaterMachineState(machine)
class Cooling(override val machine: WaterMachine) : WaterMachineState(machine)

class WaterMachine {
    var state: WaterMachineState
    val off = Off(this)
    val heating = Heating(this)
    val cooling = Cooling(this)

    init {
        this.state = off
    }

    fun turnHeating() {
        this.state.turnHeating()
    }

    fun turnCooling() {
        this.state.turnCooling()
    }

    fun turnOff() {
        this.state.turnOff()
    }
}

enum class Moment {
    EARLY_MORNING,      //早上上班
    DRINGING_WATER,     //日常饮水
    INSTANCE_NOODLES,   //Shaw 吃泡面
    AFTER_WORK          //下班
}

fun waterMachineOps(machine: WaterMachine, moment: Moment) {
    when (moment) {
        Moment.EARLY_MORNING, Moment.DRINGING_WATER -> when (machine.state) {
            !is Cooling -> machine.turnCooling()
        }
        Moment.INSTANCE_NOODLES -> when (machine.state) {
            !is Heating -> machine.turnHeating()
        }
        Moment.AFTER_WORK -> when (machine.state) {
            !is Off -> machine.turnOff()
        }
        else -> Unit
    }
}

fun main(args: Array<String>) {
    val machine = WaterMachine()
    waterMachineOps(machine, Moment.DRINGING_WATER)
    waterMachineOps(machine, Moment.INSTANCE_NOODLES)
    waterMachineOps(machine, Moment.DRINGING_WATER)
    waterMachineOps(machine, Moment.AFTER_WORK)
}