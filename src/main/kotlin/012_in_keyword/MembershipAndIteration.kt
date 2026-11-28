package lesson012.inkeyword

fun main() {
    val allowedRoles = setOf("admin", "editor")
    println("admin" in allowedRoles) // true
    println(11 !in 1..10) // true

    for (number in 1..3) {
        println(number) // 1, then 2, then 3
    }
}
