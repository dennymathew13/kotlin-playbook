package lesson007.defaultnamed

fun welcome(name: String, greeting: String = "Hello"): String = "$greeting, $name!"

fun main() {
    println(welcome("Denny")) // Hello, Denny!
    println(welcome(greeting = "Welcome", name = "Maya")) // Welcome, Maya!
}
