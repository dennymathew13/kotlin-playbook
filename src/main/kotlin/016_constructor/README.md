# 016 — Constructor

A constructor receives the values needed to create an object. Kotlin places the primary constructor in the class header and uses property initializers or `init` blocks for setup.

## Constructor parameters and properties

```kotlin
class Order(val id: Int, quantity: Int) {
    val quantity: Int = quantity
}
```

`id` is a property because it uses `val`. The `quantity` parameter is only an input until the class stores it in a property.

## Initialization

```kotlin
init {
    println("Created order $id")
}
```

```kotlin
val order = Order(id = 10, quantity = 2)
println(order.quantity)
```

Output:

```text
Created order 10
2
```

## Important rules

- Add `val` or `var` to a constructor parameter to make it a property directly.
- Primary-constructor parameters are available to initializers and `init` blocks.
- Initializers and `init` blocks run in their order in the class body.
- A primary constructor cannot contain statements directly.
- Constructors should establish a valid object without long-running work.

## Interview questions

**Is every constructor parameter a property?** No. It needs `val` or `var`, or it must be stored separately.

**Where does primary-constructor logic go?** In property initializers and `init` blocks.

**When do `init` blocks run?** During object construction, in their order among property initializers.

## Quick revision

- Constructor inputs go in the class header.
- `val`/`var` creates a property.
- Use `init` for validation or setup.
- Keep construction fast and predictable.

## Source code

[Constructor.kt](./Constructor.kt)

## Next lesson

017 — Visibility Modifiers
