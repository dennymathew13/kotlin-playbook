# 021 — Sets

A set stores unique values. Use one when membership matters but positions and duplicate entries do not.

## Basic syntax

```kotlin
val tags: Set<String> = setOf("kotlin", "android", "kotlin")

println(tags) // [kotlin, android]
println("kotlin" in tags) // true
```

The duplicate string is kept only once.

Use a mutable set when values must be added or removed:

```kotlin
val selectedIds = mutableSetOf(1, 2)
selectedIds.add(3)
selectedIds.remove(1)

println(selectedIds) // [2, 3]
```

## Important rules

- A set contains no duplicate values according to equality.
- `Set` exposes read operations; `MutableSet` adds mutation operations.
- Set position is not part of the abstraction; do not use index-based logic.
- Hash-based sets depend on correct and stable `equals()` and `hashCode()` behavior.
- Do not rely on iteration order unless the chosen set type promises it.

## List or set?

Use a list when order, indices, or duplicates matter. Use a set for uniqueness and membership checks.

## Interview questions

**How does a set decide whether two values are duplicates?** Through equality; hash-based sets also use hash codes.

**Can a set contain mutable objects?** Yes, but changing equality-related state while stored can break lookup.

**Does a set support index access?** No.

## Quick revision

- `setOf` creates a read-only set.
- `mutableSetOf` allows additions and removals.
- Duplicates are removed.
- Use `in` for membership.

## Source code

[Sets.kt](./Sets.kt)

## Next lesson

022 — Maps
