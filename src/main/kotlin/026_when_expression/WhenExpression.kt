package lesson026.whenexpression

fun statusMessage(code: Int): String = when (code) {
    200, 201 -> "Success"
    in 400..499 -> "Client error"
    in 500..599 -> "Server error"
    else -> "Unknown status"
}

fun main() {
    println(statusMessage(201)) // Success
    println(statusMessage(404)) // Client error

    val score = 82
    val grade = when {
        score >= 90 -> "A"
        score >= 75 -> "B"
        else -> "C"
    }
    println(grade) // B
}
