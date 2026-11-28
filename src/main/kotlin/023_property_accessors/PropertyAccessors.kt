package lesson023.propertyaccessors

class Temperature(celsius: Double) {
    var celsius: Double = celsius
        set(value) {
            // Keep the stored value at or above absolute zero.
            field = if (value < -273.15) -273.15 else value
        }

    val fahrenheit: Double
        get() = celsius * 9 / 5 + 32
}

fun main() {
    val temperature = Temperature(20.0)
    temperature.celsius = 25.0
    println(temperature.fahrenheit) // 77.0

    // Writing celsius = value inside its setter would call the setter again.
}
