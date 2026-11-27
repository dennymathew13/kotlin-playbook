# For Loop and Ranges

Kotlin `for` iterates over anything that follows the iteration convention. Ranges and progressions describe ordered numeric traversal.

## Runnable example

[ForLoopandRanges.kt](./ForLoopandRanges.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `1..3` | Closed range including 1 and 3. |
| `0..<3` | Half-open range including 0 and excluding 3. |
| `downTo` | Creates a descending progression. |
| `step 2` | Changes the progression increment magnitude. |
| `withIndex()` | Provides index-value pairs for destructuring. |

## Step-by-step walkthrough

1. The first loop prints days 1-3.
2. The half-open range prints indices 0-2.
3. The countdown visits 5, 3, and 1.
4. `withIndex` supplies each product and its index.

## Expected output

```text
Day 1
Day 2
Day 3
Index 0
Index 1
Index 2
5
3
1
0: Phone
1: Case
```

## Important rules and behavior

- Kotlin has no C-style `for(init; test; update)` loop.
- `..` includes both endpoints.
- A positive `step` is used with `downTo`; the direction is already descending.
- Prefer direct element iteration when the index is unnecessary.

## Common mistakes and edge cases

- Using `..` when an exclusive upper bound is required.
- Indexing a list manually when direct iteration is clearer.
- Assuming every range materializes a list of values.

## Kotlin compared with Java

Kotlin's `for` resembles enhanced-for, while progressions replace many counter-based loops.

## Android relevance

Useful for small deterministic iteration; avoid allocations and expensive work in hot drawing or recomposition paths.

## Interview questions and answers

### 1. Does `1..5` include 5?

Yes. Use `1..<5` or `1 until 5` to exclude it.

### 2. Is a range necessarily a `List`?

No. Ranges/progressions represent bounds and iteration behavior.

### 3. How do you get both index and value?

Use `withIndex()` or `forEachIndexed`.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
