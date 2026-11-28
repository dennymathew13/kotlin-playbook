package lesson017.visibility

internal class Session(private val token: String) {
    fun maskedToken(): String = "***${token.takeLast(2)}"
}

private const val DEFAULT_USER = "guest"

fun main() {
    println("$DEFAULT_USER: ${Session("abcdef").maskedToken()}") // guest: ***ef

    // Session("abcdef").token // Compile-time error: token is private.
}
