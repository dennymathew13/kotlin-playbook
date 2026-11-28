package lesson015.properties

class Account(val id: String) {
    var balance: Int = 0
}

fun main() {
    val account = Account("A-1")
    account.balance += 500
    println("${account.id}: ${account.balance}") // A-1: 500

    // account.id = "A-2" // Compile-time error: val property has no setter.
}
