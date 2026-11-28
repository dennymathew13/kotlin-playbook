# 022 — Maps

A map stores values by unique keys. It is useful for lookups such as a product name to its price.

## Basic syntax

```kotlin
val prices: Map<String, Int> = mapOf(
    "phone" to 500,
    "case" to 20,
)

println(prices["phone"])   // 500
println(prices["charger"]) // null
```

Lookup returns a nullable value because the key may be absent. A default can be supplied:

```kotlin
println(prices.getOrDefault("charger", 0)) // 0
```

Use `MutableMap` when entries need to change:

```kotlin
val stock = mutableMapOf("phone" to 3)
stock["case"] = 5
println(stock) // {phone=3, case=5}
```

## Important rules

- Keys are unique; assigning the same key replaces its value in a mutable map.
- `map[key]` is indexing syntax for `get(key)`.
- A missing key normally returns `null`, not an exception.
- `Map` exposes read operations; `MutableMap` also exposes updates.
- Read-only does not guarantee that no mutable reference exists elsewhere.

## Common mistake

When nullable values are allowed, `map[key] == null` cannot distinguish a missing key from a key mapped to `null`. Use `containsKey(key)` when that distinction matters.

## Interview questions

**What does `"phone" to 500` create?** A `Pair` used as a map entry by `mapOf`.

**What does lookup return for a missing key?** `null`, unless a different API such as `getValue` or `getOrDefault` is used.

**Are map keys unique?** Yes.

## Quick revision

- `mapOf` creates a read-only map.
- `mutableMapOf` creates a mutable map.
- Use `map[key]` to read or write.
- Missing lookup results are nullable.

## Source code

[Maps.kt](./Maps.kt)

## Next lesson

023 — Property Accessors
