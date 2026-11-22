package lesson006.loops

fun main() {
    // A for loop repeats once for every value in a collection or range.
    for (number in 1..5) {
        println("For loop: $number")
    }

    // 1..5 is a range containing the numbers 1 through 5.
    // downTo counts backward, and step controls how much the value changes.
    for (number in 5 downTo 1 step 2) {
        println("Backward range: $number")
    }

    // until creates a range that does not include its ending value.
    for (number in 1 until 5) {
        println("Until range: $number")
    }

    // A while loop repeats as long as its condition remains true.
    var whileCount = 1

    while (whileCount <= 3) {
        println("While loop: $whileCount")
        whileCount++ // Increase the value to prevent an infinite loop.
    }

    // A do-while loop runs its block once before checking the condition.
    var doWhileCount = 1

    do {
        println("Do-while loop: $doWhileCount")
        doWhileCount++
    } while (doWhileCount <= 3)

    // break immediately stops the nearest loop.
    for (number in 1..10) {
        if (number == 4) {
            break
        }

        println("Before break: $number")
    }

    // continue skips the rest of the current repetition and starts the next one.
    for (number in 1..5) {
        if (number == 3) {
            continue
        }

        println("Continue example: $number")
    }
}
