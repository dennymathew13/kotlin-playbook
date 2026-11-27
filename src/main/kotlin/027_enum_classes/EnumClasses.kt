package lesson027.enumclasses

// An enum class represents a fixed set of related values.
// Each constant is an object of the TrafficLight enum class.
enum class TrafficLight(val color: String, val durationInSeconds: Int) {
    RED("Red", 30),
    YELLOW("Yellow", 5),
    GREEN("Green", 25);

    // The semicolon above separates the constants from properties and methods.
    // Enum classes can contain methods like regular classes.
    fun displayDetails() {
        println("$color light lasts for $durationInSeconds seconds.")
    }
}

// when works well with enums because their possible values are known.
// No else branch is needed when every enum constant is handled.
fun getAction(light: TrafficLight): String {
    return when (light) {
        TrafficLight.RED -> "Stop"
        TrafficLight.YELLOW -> "Slow down"
        TrafficLight.GREEN -> "Go"
    }
}

fun main() {
    // Access an enum constant using the enum class name.
    val currentLight = TrafficLight.RED

    // Enum constants can provide values for their properties.
    println("Current color: ${currentLight.color}")
    println("Duration: ${currentLight.durationInSeconds} seconds")

    // Methods can be called on enum constants.
    currentLight.displayDetails()

    // Pass the enum constant to a when expression.
    println("Action: ${getAction(currentLight)}")

    // name and ordinal are inherited from Enum.
    println("Name: ${currentLight.name}, ordinal: ${currentLight.ordinal}")

    // entries contains all constants declared in the enum class.
    for (light in TrafficLight.entries) {
        println("${light.name}: ${getAction(light)}")
    }
}
