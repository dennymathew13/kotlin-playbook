package lesson024.extensions
data class User(val firstName: String, val lastName: String)
fun User.displayName(): String = "$firstName $lastName"
fun String.maskEmail(): String = replaceBefore('@', "***")
open class Screen
class HomeScreen : Screen()
fun Screen.kind() = "Screen"
fun HomeScreen.kind() = "HomeScreen"
fun describe(screen: Screen) = screen.kind() // Static receiver type chooses Screen extension.
fun main() {
    println(User("Maya", "Rao").displayName())
    println("maya@example.com".maskEmail())
    println(describe(HomeScreen())) // Expected: Screen
}
