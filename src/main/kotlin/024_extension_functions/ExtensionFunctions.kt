package lesson024.extensions

class User(val firstName: String, val lastName: String)

fun User.displayName(): String = "$firstName $lastName"

open class Screen
class HomeScreen : Screen()

fun Screen.kind(): String = "Screen"
fun HomeScreen.kind(): String = "HomeScreen"

fun describe(screen: Screen): String = screen.kind()

fun main() {
    println(User("Maya", "Rao").displayName()) // Maya Rao

    // Extensions are selected from the variable's declared type.
    println(HomeScreen().kind()) // HomeScreen
    println(describe(HomeScreen())) // Screen
}
