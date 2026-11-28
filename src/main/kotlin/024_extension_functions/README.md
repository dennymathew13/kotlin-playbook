# 024 — Extension Functions

An extension function adds convenient call syntax for an existing type without changing or inheriting from that type.

## Basic syntax

```kotlin
class User(val firstName: String, val lastName: String)

fun User.displayName(): String = "$firstName $lastName"

println(User("Maya", "Rao").displayName()) // Maya Rao
```

`User` is the receiver type. Inside the extension, its visible members can be used directly.

Extensions do not become real class members. They are resolved statically from the receiver's declared type:

```kotlin
fun Screen.kind() = "Screen"
fun HomeScreen.kind() = "HomeScreen"

fun describe(screen: Screen) = screen.kind()

println(HomeScreen().kind())    // HomeScreen
println(describe(HomeScreen())) // Screen
```

`describe` receives a value declared as `Screen`, so `Screen.kind()` is selected.

## Important rules

- Extensions do not modify the original class.
- Resolution uses the declared receiver type, not runtime virtual dispatch.
- A real member with the same applicable signature wins over an extension.
- An extension cannot access private members of its receiver.
- Keep extensions small and closely related to their receiver type.

## Interview questions

**Do extensions add methods to a class?** No. They provide member-like call syntax for ordinary functions.

**How are extensions resolved?** Statically, using the receiver's declared type and the functions in scope.

**Member or extension: which wins?** The member.

**Can an extension access private state?** No.

## Quick revision

- Declare one with `fun Type.functionName()`.
- Call it with `value.functionName()`.
- Extensions are statically resolved.
- They do not change the receiver class.

## Source code

[ExtensionFunctions.kt](./ExtensionFunctions.kt)

## Next lesson

025 — Overloading
