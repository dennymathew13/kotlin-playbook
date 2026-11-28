package lesson010.whileloop

fun main() {
    var attempt = 1
    while (attempt <= 3) {
        println("Attempt $attempt") // Attempt 1 through Attempt 3
        attempt++
    }

    var countdown = 0
    do {
        println(countdown) // 0: do-while always runs at least once.
        countdown--
    } while (countdown > 0)
}
