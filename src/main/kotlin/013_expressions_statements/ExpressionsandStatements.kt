package lesson013.expressionsstatements
fun main() {
    val score = 82
    val grade = if (score >= 80) "A" else "B"
    val description = run {
        val next = score + 1 // declaration: statement
        "Next score: $next" // final expression is the block value
    }
    println("$grade; $description")
    // val result = (score = 90) // Assignment is not a value-producing expression.
}
