package DesignPatterns

import java.lang.IllegalArgumentException

//构建者模式
class Robot private constructor(
        val code: String,
        val battery: String?,
        val height: Int?,
        val weight: Int?) {
    class Builder(val code: String) {
        private var battery: String? = null
        private var height: Int? = null
        private var weight: Int? = null

        fun setBattery(battery: String?): Builder {
            this.battery = battery
            return this
        }

        fun setHeight(height: Int?): Builder {
            this.height = height
            return this
        }

        fun setWeight(weight: Int?): Builder {
            this.weight = weight
            return this
        }

        fun build(): Robot {
            if (weight != null && battery == null) {
                throw IllegalArgumentException("Battery should be determined when setting weight.")
            } else {
                return Robot(code, battery, height, weight)
            }
        }
    }
}

//具名的可选参数
class Robot1(
        val code: String,
        val battery: String? = null,
        val height: Int? = null,
        val weight: Int? = null
) {
    init {
        //require方法对参数进行约束
        require(weight == null || battery != null) {
            "Battery shoule be determined when seting weight"
        }
    }
}

fun main(args: Array<String>) {
    val robot = Robot.Builder("007")
            .setBattery("R6")
            .setHeight(100)
            .setWeight(80)
            .build()

    val robot1 = Robot1(code = "007")
    val robot2 = Robot1(code = "007", battery = "R6")
    val robot3 = Robot1(code = "007", height = 100, weight = 80)

    //val robot4=Robot1(code="007",weight=100)
}