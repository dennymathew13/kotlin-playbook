# 019 — Lists

A list is an ordered collection that keeps duplicates. Kotlin provides read-only and mutable list interfaces.

## Read-only list

```kotlin
val products: List<String> = listOf("Phone", "Case", "Phone")

println(products[0]) // Phone
println(products.size) // 3
```

Indices start at zero. Accessing an index outside the list throws an exception.

## Mutable list

```kotlin
val cart: MutableList<String> = mutableListOf("Phone")
cart.add("Case")
println(cart) // [Phone, Case]
```

Read-only is not the same as immutable:

```kotlin
val readOnlyCart: List<String> = cart
cart.add("Charger")
println(readOnlyCart) // [Phone, Case, Charger]
```

Both references point to the same mutable object, but mutation is unavailable through the `List` reference.

## Important rules

- Lists preserve order and allow duplicates.
- `List` exposes reads; `MutableList` also exposes changes.
- A read-only view can still reflect changes made through another reference.
- `toMutableList()` creates a new list structure but only shallow-copies elements.
- Use `getOrNull(index)` when an index may be outside the list.

## Interview questions

**Is a Kotlin `List` always immutable?** No. It is a read-only interface and may view a mutable list.

**Does `toMutableList()` deep-copy elements?** No.

**Are duplicates allowed?** Yes.

## Quick revision

- `listOf` creates a read-only list reference.
- `mutableListOf` supports additions and removals.
- Lists are ordered, indexed, and allow duplicates.
- Read-only does not necessarily mean immutable.

## Source code

[Lists.kt](./Lists.kt)

## Next lesson

020 — Varargs
