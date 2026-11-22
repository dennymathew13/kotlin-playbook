package lesson005.conditionals

fun main() {
    // if runs its block only when the condition is true.
    val temperature = 30

    if (temperature > 25) {
        println("It is a hot day.")
    }

    // else if checks another condition when the previous condition is false.
    // else runs when none of the earlier conditions are true.
    val score = 75

    if (score >= 90) {
        println("Grade: A")
    } else if (score >= 75) {
        println("Grade: B")
    } else if (score >= 50) {
        println("Grade: C")
    } else {
        println("Grade: F")
    }

    // if is an expression in Kotlin, so its result can be stored in a variable.
    val age = 20
    val ageGroup = if (age >= 18) {
        "Adult"
    } else {
        "Minor"
    }

    println("Age group: $ageGroup")

    // when compares a value against several possible choices.
    // It is useful when there are many conditions to check.
    val dayNumber = 3

    when (dayNumber) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
        7 -> println("Sunday")
        else -> println("Invalid day number")
    }

    // when is also an expression, so it can return a value.
    val trafficLight = "Red"
    val action = when (trafficLight) {
        "Green" -> "Go"
        "Yellow" -> "Slow down"
        "Red" -> "Stop"
        else -> "Unknown signal"
    }

    println("Traffic light action: $action")
}
