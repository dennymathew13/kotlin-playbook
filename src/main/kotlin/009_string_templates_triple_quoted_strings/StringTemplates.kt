package lesson009.stringtemplates

fun main() {
    val name = "Maya"
    val lessons = 3
    println("$name completed $lessons lessons.") // Maya completed 3 lessons.
    println("Next lesson: ${lessons + 1}") // Next lesson: 4

    val message = """
        Kotlin keeps line breaks.
        Triple-quoted strings need no " escaping.
    """.trimIndent()
    println(message)
}
