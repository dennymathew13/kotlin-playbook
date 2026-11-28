package lesson008.ifexpression

fun main() {
    val score = 82
    val result = if (score >= 80) "Pass" else "Try again"
    println(result) // Pass

    val discount = if (score >= 90) {
        20
    } else {
        10
    }
    println(discount) // 10
}
