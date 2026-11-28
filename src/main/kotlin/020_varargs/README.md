# 020 — Varargs

A `vararg` parameter accepts zero or more values in one call. It is useful when callers naturally provide a small, varying number of arguments.

## Basic syntax

```kotlin
fun total(vararg prices: Int): Int = prices.sum()

println(total(5, 10, 20)) // 35
```

Inside the function, `prices` is an array-like value. For `vararg Int`, Kotlin uses `IntArray`.

## Spread operator

Use `*` to pass an existing array as separate arguments:

```kotlin
val prices = intArrayOf(10, 20)
println(total(5, *prices)) // 35

// total(prices) // Compile-time error
```

Without `*`, the array is one value and does not match an `Int` argument.

## Important rules

- A function may have only one `vararg` parameter.
- A caller may pass no values, separate values, or a spread array.
- If parameters follow a `vararg`, callers often need named arguments for them.
- Spreading an array may create a copy, so avoid large repeated spreads in hot code.
- Prefer a collection parameter when the input is already a large collection.

## Interview questions

**How do you pass an existing array to a vararg?** Prefix it with `*`.

**How many vararg parameters can a function have?** One.

**What is `vararg Int` inside the function?** An `IntArray`.

## Quick revision

- Declare with `vararg values: Type`.
- Call with separate arguments.
- Use `*array` to spread an array.
- Varargs are best for small, convenient argument lists.

## Source code

[VarargsVariableArgumentLists.kt](./VarargsVariableArgumentLists.kt)

## Next lesson

021 — Sets
