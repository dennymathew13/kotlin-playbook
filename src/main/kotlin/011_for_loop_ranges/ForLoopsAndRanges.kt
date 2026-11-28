package lesson011.forloopranges

fun main() {
    for (day in 1..3) {
        println("Day $day") // Day 1 through Day 3
    }

    for (index in 0..<3) {
        println("Index $index") // Index 0 through Index 2
    }

    for (countdown in 5 downTo 1 step 2) {
        println(countdown) // 5, 3, 1
    }
}
