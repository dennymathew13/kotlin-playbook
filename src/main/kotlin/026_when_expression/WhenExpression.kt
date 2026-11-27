package lesson026.whenexpression

fun httpMessage(statusCode: Int): String = when (statusCode) {
    200, 201 -> "Success" // Several values can share one branch.
    in 400..499 -> "Client error" // in performs a range membership check.
    in 500..599 -> "Server error"
    else -> "Unexpected status"
}

fun describe(value: Any?): String = when (value) {
    null -> "Missing value"
    is String -> "Text length: ${value.length}" // Smart cast to String in this branch.
    is Int -> "Integer doubled: ${value * 2}"
    else -> "Other value: $value"
}

fun deliveryFee(total: Int, isPremiumUser: Boolean): Int = when {
    total < 0 -> error("Total cannot be negative")
    isPremiumUser -> 0
    total >= 500 -> 0
    else -> 40
}

fun main() {
    println(httpMessage(201))
    println(httpMessage(404))
    println(describe("Kotlin"))
    println(describe(null))
    println("Delivery fee: ${deliveryFee(total = 300, isPremiumUser = false)}")
}
