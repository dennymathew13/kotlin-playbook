package lesson010.whileloop
fun main() {
    var attempts = 1
    while (attempts <= 3) {
        println("Attempt $attempts")
        attempts++
    }
    var input: String? = null
    var polls = 0
    do {
        polls++
        input = if (polls == 2) "ready" else null
    } while (input == null)
    println(input) // do-while ran before checking.
}
