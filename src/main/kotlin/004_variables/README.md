# 004 — Variables

Variables give names to values. Kotlin separates read-only references (`val`) from reassignable references (`var`).

## `val` and `var`

```kotlin
val language = "Kotlin"
var lesson = 4

lesson = 5
// language = "Java" // Compile-time error
```

Prefer `val` unless the reference genuinely needs reassignment.

## A `val` object can still be mutable

```kotlin
class Cart(var itemCount: Int)

val cart = Cart(1)
cart.itemCount = 2 // Allowed

// cart = Cart(0) // Not allowed
```

`val` protects the reference from pointing to another object. It does not make the referenced object deeply immutable.

## Type inference

```kotlin
val name = "Maya" // Inferred as String
val count: Int = 3 // Explicit type
```

Inference is still static typing: `name` cannot later hold an `Int`.

## Important rules

- `val` can be assigned once.
- `var` can be reassigned.
- `val` does not guarantee object immutability.
- The compiler can infer a type from an initializer.
- Use meaningful names that explain the value's role.

## Interview questions

**Does `val` make an object immutable?** No. It prevents reassignment of that reference.

**What is type inference?** The compiler determines a variable's static type from its initializer.

**Why prefer `val`?** Fewer possible state changes make code easier to reason about.

## Quick revision

- `val`: read-only reference.
- `var`: reassignable reference.
- Prefer `val` by default.
- Inferred variables remain statically typed.

## Source code

[Variables.kt](./Variables.kt)

## Next lesson

005 — Data Types
