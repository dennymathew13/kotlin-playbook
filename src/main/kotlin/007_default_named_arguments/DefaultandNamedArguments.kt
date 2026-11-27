package lesson007.defaultnamedarguments
fun createUser(name: String, role: String = "viewer", active: Boolean = true) =
    "$name ($role), active=$active"
fun main() {
    println(createUser("Maya"))
    println(createUser(name = "Arun", active = false))
    println(createUser(role = "admin", name = "Lee"))
}
