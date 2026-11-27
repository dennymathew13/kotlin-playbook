package lesson011.forloopranges
fun main() {
    for (day in 1..3) println("Day $day")
    for (index in 0..<3) println("Index $index")
    for (countdown in 5 downTo 1 step 2) println(countdown)
    val products = listOf("Phone", "Case")
    for ((index, product) in products.withIndex()) println("$index: $product")
}
