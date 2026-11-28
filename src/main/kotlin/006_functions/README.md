# 006 — Functions

A function gives a name to reusable behavior. Parameters receive input, and a return type describes the result.

## Expression body

```kotlin
fun subtotal(price: Double, quantity: Int): Double = price * quantity
```

The expression after `=` is returned automatically.

## Block body

```kotlin
fun printReceipt(total: Double) {
    println("Total: %.2f".format(total))
}
```

This function performs an action and returns `Unit`, meaning it has no useful result for the caller.

```kotlin
val total = subtotal(12.5, 2)
printReceipt(total) // Total: 25.00
```

## Important rules

- Declare functions with `fun`.
- Parameter syntax is `name: Type`.
- Parameters are read-only inside the function.
- Expression bodies return their expression automatically.
- A block body returning a value normally needs an explicit `return`.
- Keep each function focused on one clear task.

## Common mistakes

- Writing the type before the parameter name.
- Forgetting `return` in a value-producing block body.
- Combining unrelated work in one large function.

## Interview questions

**What is `Unit`?** The Kotlin type used when a function has no meaningful result.

**Expression body versus block body?** An expression body uses `=`; a block body uses braces and explicit statements.

**Can Kotlin functions be declared outside a class?** Yes, as top-level functions.

## Quick revision

- `fun name(parameters): ReturnType` declares a function.
- Call it with `name(arguments)`.
- `=` creates a concise expression body.
- `Unit` represents no useful returned value.

## Source code

[Functions.kt](./Functions.kt)

## Next lesson

007 — Default and Named Arguments
