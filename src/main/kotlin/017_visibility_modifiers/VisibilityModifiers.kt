package lesson017.visibility
internal class Session(private val token: String) {
    fun maskedToken(): String = "***${token.takeLast(2)}"
    protected class Marker // Visible only to this class and subclasses.
}
private const val DEFAULT_USER = "guest" // File-private top-level declaration.
fun main() { println("$DEFAULT_USER: ${Session("abcdef").maskedToken()}") }
