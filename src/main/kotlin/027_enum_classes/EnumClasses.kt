package lesson027.enumclasses

enum class TrafficLight(val instruction: String) {
    RED("Stop"),
    YELLOW("Wait"),
    GREEN("Go"),
}

fun main() {
    val light = TrafficLight.GREEN
    println(light.instruction) // Go

    // entries contains every constant in declaration order.
    println(TrafficLight.entries.joinToString()) // RED, YELLOW, GREEN

    val message = when (light) {
        TrafficLight.RED -> "Cars stop"
        TrafficLight.YELLOW -> "Cars slow down"
        TrafficLight.GREEN -> "Cars move"
    }
    println(message) // Cars move

    // Do not persist light.ordinal: reordering constants changes it.
}
