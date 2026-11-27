package lesson022.maps
fun main() {
    val prices: Map<String, Int> = mapOf("phone" to 500, "case" to 20)
    println(prices["phone"])
    println(prices.getOrDefault("charger", 0))
    val nullable = mapOf("known" to null)
    println("known value=${nullable["known"]}")
    println("missing value=${nullable["missing"]}")
    println(nullable.containsKey("known")) // true: distinguishes mapped-to-null from missing.
}
