package lesson023.propertyaccessors
class Temperature(celsius: Double) {
    var celsius: Double = celsius
        set(value) {
            require(value >= -273.15) { "Below absolute zero" }
            field = value
        }
    val fahrenheit: Double
        get() = celsius * 9 / 5 + 32 // Computed property: no backing field.
}
fun main() {
    val temperature = Temperature(20.0)
    temperature.celsius = 25.0
    println(temperature.fahrenheit) // Expected: 77.0
}
