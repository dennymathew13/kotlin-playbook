package lesson012.inkeyword
operator fun ClosedRange<Int>.contains(text: String): Boolean =
    text.toIntOrNull()?.let { number -> number in this } == true
fun main() {
    val allowedRoles = setOf("admin", "editor")
    println("admin" in allowedRoles) // true
    println(11 !in 1..10) // true
    println("7" in 1..10) // true: calls the custom contains extension.
}
