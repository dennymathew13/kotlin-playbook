package lesson025.overloading

fun findOrder(id: Int): String = "Order number: $id"

fun findOrder(reference: String): String = "Order reference: $reference"

fun findOrder(id: Int, includeItems: Boolean): String =
    if (includeItems) "Order $id with items" else findOrder(id)

fun main() {
    println(findOrder(42)) // Order number: 42
    println(findOrder("WEB-42")) // Order reference: WEB-42
    println(findOrder(42, includeItems = true)) // Order 42 with items

    // fun findOrder(id: Int): Boolean = true
    // Compile-time error: functions cannot be overloaded by return type alone.
}
