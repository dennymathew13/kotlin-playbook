# Sets

A set models unique membership. It is the right abstraction when presence and uniqueness matter more than position.

## Runnable example

[Sets.kt](./Sets.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `Set<T>` | Read-only set interface. |
| `MutableSet<T>` | Set with add/remove operations. |
| `setOf(...)` | Creates a set from values. |
| `value in set` | Checks membership. |

## Step-by-step walkthrough

1. The duplicate `kotlin` string collapses to one entry.
2. ID 3 is added to the mutable selection.
3. Membership confirms ID 2 is selected.
4. Equal data-class users collapse to one element.

## Expected output

```text
[kotlin, android]
true
1
```

## Important rules and behavior

- Set uniqueness uses equality and hashing for hash-based sets.
- Equal objects must have equal hash codes.
- Set semantics do not include an index.
- Choose an explicit ordered/sorted implementation when order is a required contract.

## Common mistakes and edge cases

- Depending accidentally on one implementation's iteration order.
- Mutating fields involved in hash/equality while an object is in a hash set.
- Using a list and repeatedly deduplicating it.

## Kotlin compared with Java

Concepts match Java sets, while Kotlin provides concise factories and read-only interfaces.

## Android relevance

Useful for selected IDs, permissions, tags, and deduplicating events or identifiers.

## Interview questions and answers

### 1. How does a hash set decide uniqueness?

Using `equals` and `hashCode`.

### 2. Can a set contain mutable objects?

Yes, but mutating equality/hash fields can make lookup unreliable.

### 3. Does a set provide index access?

No; position is not part of the set abstraction.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
