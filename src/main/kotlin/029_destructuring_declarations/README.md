# 029 — Destructuring Declarations

Destructuring extracts an object's components into separate local variables. It is useful when the component order is clear, especially with pairs, data classes, and map entries.

## Basic syntax

```kotlin
val user = 7 to "Maya"
val (id, name) = user

println("$id: $name") // 7: Maya
```

The compiler uses component functions:

```kotlin
val id = user.component1()
val name = user.component2()
```

Data classes automatically receive `componentN()` functions for primary-constructor properties, in declaration order.

```kotlin
data class Person(val name: String, val age: Int)

val person = Person("Arun", 30)
val (name, age) = person
```

Use `_` to skip an unwanted component. Map entries can be destructured directly in a loop:

```kotlin
val (_, age) = person

for ((product, price) in prices) {
    println("$product: $price")
}
```

## Important rules

- Destructuring is positional; variable names do not select properties.
- `_` skips the corresponding component.
- Requesting a component that does not exist is a compile-time error.
- Destructuring extracts values; it does not deep-copy an object.
- Prefer explicit property access when many components would be unclear.

## Interview questions

**How does destructuring work?** Through `operator` functions named `component1()`, `component2()`, and so on.

**Which data-class properties receive component functions?** Primary-constructor properties, in their declaration order.

**Is destructuring limited to data classes?** No. Any type with suitable accessible `componentN()` operator functions can support it.

**Does `_` call the skipped component function?** No.

## Quick revision

- `val (a, b) = value` extracts two components.
- Order matters, not variable names.
- `_` ignores a component.
- Map entries expose key and value components.

## Source code

[DestructuringDeclarations.kt](./DestructuringDeclarations.kt)

## Next lesson

030 — Nullable Types
