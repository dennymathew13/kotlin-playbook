package lesson022.maps

fun main() {
    val prices: Map<String, Int> = mapOf("phone" to 500, "case" to 20)
    println(prices["phone"]) // 500
    println(prices["charger"]) // null: this key is missing.
    println(prices.getOrDefault("charger", 0)) // 0

    val stock = mutableMapOf("phone" to 3)
    stock["case"] = 5
    println(stock) // {phone=3, case=5}
}
