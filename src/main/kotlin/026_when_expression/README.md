# 026 — `when` Expression

`when` selects the first matching branch. It is useful when several related cases would make an `if` chain hard to read, and it can return a value.

## Basic syntax

```kotlin
fun statusMessage(code: Int): String = when (code) {
    200, 201 -> "Success"
    in 400..499 -> "Client error"
    in 500..599 -> "Server error"
    else -> "Unknown status"
}
```

Branches may match single values, several values, or ranges. There is no fall-through and no `break` is needed.

A subjectless `when` checks Boolean conditions in order:

```kotlin
val grade = when {
    score >= 90 -> "A"
    score >= 75 -> "B"
    else -> "C"
}

println(grade) // B when score is 82
```

## Important rules

- Branches are checked from top to bottom; the first match wins.
- `when` can be used as an expression whose selected branch is the result.
- A value-producing `when` must cover every possible case.
- `else` supplies the fallback for open-ended values such as `Int`.
- Closed types such as enums can be exhaustive without `else` when all cases are listed.

## Common mistakes

- Putting a broad range before a narrower range.
- Expecting Java-style fall-through.
- Forgetting `else` when the compiler cannot prove exhaustiveness.

## Interview questions

**Is `when` an expression?** Yes. Its result can initialize a variable or be returned.

**Does it fall through?** No. Only the first matching branch runs.

**What is a subjectless `when`?** A `when` whose branches are Boolean conditions.

**Why avoid an unnecessary `else` for enums?** Explicit branches let the compiler flag newly added constants.

## Quick revision

- `value -> result` defines a branch.
- Commas combine matches; `in` matches ranges.
- First match wins.
- Every path needs a result when `when` returns a value.

## Source code

[WhenExpression.kt](./WhenExpression.kt)

## Next lesson

027 — Enum Classes
