# Lists

A list is an ordered collection that permits duplicates. Kotlin separates read-only and mutable collection interfaces.

## Runnable example

[Lists.kt](./Lists.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `List<String>` | Exposes read operations. |
| `MutableList<String>` | Adds mutation operations. |
| `listOf(...)` | Creates a read-only list reference. |
| `toMutableList()` | Creates a mutable list copy. |
| `products[0]` | Index access through `get`. |

## Step-by-step walkthrough

1. `products` retains order and both `Phone` values.
2. `toMutableList` copies its elements into `cart`.
3. A charger is added to `cart`.
4. `readOnlyView` and `cart` refer to the same mutable object, so clearing `cart` makes the view appear empty.

## Expected output

```text
Phone
[Phone, Case, Phone, Charger]
[]
```

## Important rules and behavior

- Read-only does not guarantee immutable.
- List indices run from 0 through `lastIndex`.
- Indexing outside bounds throws at runtime.
- Copying a collection is shallow; element objects are shared.

## Common mistakes and edge cases

- Claiming `List` is always immutable.
- Mutating a backing list behind observers.
- Using index access without checking bounds.

## Kotlin compared with Java

Kotlin exposes read-only and mutable interfaces, while Java's `List` includes mutation methods even when an implementation rejects them.

## Android relevance

Immutable list snapshots work well for UI diffing and observable state. Replace state rather than silently mutating it.

## Interview questions and answers

### 1. Are Kotlin read-only collections immutable?

Not necessarily. They may be views of mutable objects, and their elements may be mutable.

### 2. Does `toMutableList` deep-copy elements?

No. It creates a new collection structure with the same element references.

### 3. Are duplicates allowed?

Yes, and insertion order is part of list semantics.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
