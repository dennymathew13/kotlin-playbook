package lesson009.strings
fun main() {
    val user = "Maya"
    val items = 3
    println("$user has ${items + 1} items")
    val request = """
        GET /users/$user
        Accept: application/json
    """.trimIndent()
    println(request)
    println("Price: ${'$'}10") // A literal dollar sign in a template.
}
