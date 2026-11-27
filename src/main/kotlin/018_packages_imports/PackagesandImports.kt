package lesson018.packagesimports
import kotlin.math.roundToInt as rounded
fun main() {
    println(4.6.rounded()) // Alias avoids conflicts and documents intent. Expected: 5
}
