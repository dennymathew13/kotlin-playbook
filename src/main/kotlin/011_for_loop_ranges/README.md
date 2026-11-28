# 011 — For Loops and Ranges

A `for` loop visits each value in a range, progression, or collection. Ranges make common counting loops concise.

## Inclusive and exclusive ranges

```kotlin
for (day in 1..3) {
    println("Day $day")
}
```

`1..3` includes both 1 and 3. Use `..<` to exclude the upper bound:

```kotlin
for (index in 0..<3) {
    println("Index $index")
}
```

This prints indices 0, 1, and 2.

## Descending progressions

```kotlin
for (countdown in 5 downTo 1 step 2) {
    println(countdown)
}
```

Output:

```text
5
3
1
```

## Important rules

- `..` includes both endpoints.
- `..<` excludes the upper endpoint.
- `downTo` creates a descending progression.
- `step` changes the distance between visited values and must be positive.
- Kotlin has no C-style `for (start; condition; update)` loop.

## Interview questions

**Does `1..5` include 5?** Yes.

**How do you exclude the upper bound?** Use `..<`, such as `0..<size`.

**Is a range a materialized list?** No. It represents bounds and iteration behavior.

## Quick revision

- `for (item in values)` iterates.
- `1..3` is inclusive.
- `0..<3` excludes 3.
- `downTo` and `step` control a progression.

## Source code

[ForLoopsAndRanges.kt](./ForLoopsAndRanges.kt)

## Next lesson

012 — `in` Keyword
