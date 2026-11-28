package lesson013.expressionsstatements

fun main() {
    val score = 82
    val grade = if (score >= 80) "A" else "B"
    println(grade) // A: if produced a value.

    var nextScore = score
    nextScore = 83 // Assignment is a statement.
    println(nextScore) // 83

    // val result = (score = 90) // Assignment does not produce a value.
}
