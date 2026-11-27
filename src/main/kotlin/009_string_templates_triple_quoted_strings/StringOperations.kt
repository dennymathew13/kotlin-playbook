package lesson051.stringoperations

fun main() {
    val language = "Kotlin"

    // String templates insert variables and expressions into text.
    println("$language has ${language.length} characters.")

    // Common String operations return new values because Strings are immutable.
    println(language.uppercase())
    println(language.lowercase())
    println(language.substring(0, 3))
    println(language.replace("Kotlin", "Kotlin/JVM"))

    val technologies = "Kotlin,Android,Ktor"
    val technologyList = technologies.split(",")
    println("Split values: $technologyList")
    println("Contains Android: ${technologies.contains("Android")}")

    // Triple-quoted raw Strings can span lines without escaping quotes or backslashes.
    val requestBody = """
        {
          "language": "Kotlin",
          "platform": "JVM"
        }
    """.trimIndent()
    println(requestBody)

    // buildString efficiently creates text from several pieces.
    val summary = buildString {
        append("Mobile: Android")
        appendLine()
        append("Backend: Ktor or Spring")
    }
    println(summary)
}
