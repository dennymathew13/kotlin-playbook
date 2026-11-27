package lesson025.overloading

// Same function name, different parameter types.
fun findOrder(orderId: Int): String = "Order number: $orderId"

fun findOrder(reference: String): String = "Order reference: $reference"

// Same name and first parameter, but a different parameter count.
fun findOrder(orderId: Int, includeItems: Boolean): String =
    if (includeItems) "Order number: $orderId with items" else findOrder(orderId)

fun describe(value: Any): String = "Any: $value"

fun describe(value: String): String = "String with ${value.length} characters"

fun main() {
    println(findOrder(42))
    println(findOrder("WEB-42"))
    println(findOrder(orderId = 42, includeItems = true))

    println(describe("Kotlin"))

    val language: Any = "Kotlin"
    println(describe(language)) // The declared type is Any, so describe(Any) is selected.

    // fun findOrder(orderId: Long): Int = orderId.toInt()
    // fun findOrder(orderId: Long): String = orderId.toString()
    // Compile-time error: functions cannot be overloaded by return type alone.
}
