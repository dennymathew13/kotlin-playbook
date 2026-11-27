# `when` Expression

`when` chooses the first matching branch from several alternatives. It replaces many Java `switch` statements, but it is more expressive: branches can match values, several values, ranges, types, or arbitrary Boolean conditions.

`when` is an expression, so it can directly return a value.

## Runnable example

[WhenExpression.kt](./WhenExpression.kt)

## Basic syntax

```kotlin
val message = when (statusCode) {
    200, 201 -> "Success"
    in 400..499 -> "Client error"
    in 500..599 -> "Server error"
    else -> "Unexpected status"
}
```

| Syntax | Meaning |
|---|---|
| `when (statusCode)` | Evaluates one subject and compares branches against it. |
| `200, 201` | Matches either listed value. |
| `in 400..499` | Uses a membership test against a range. |
| `->` | Separates a condition from its result or block. |
| `else` | Handles every case not matched earlier. |

Unlike Java's traditional `switch`, Kotlin branches do not fall through. No `break` is needed.

## Step-by-step walkthrough

### HTTP status matching

`httpMessage(201)` checks branches from top to bottom. The first branch contains both 200 and 201, so it returns `Success`.

`httpMessage(404)` does not match the first branch. It belongs to `400..499`, so the second branch returns `Client error`.

### Null and type matching

```kotlin
fun describe(value: Any?): String = when (value) {
    null -> "Missing value"
    is String -> "Text length: ${value.length}"
    is Int -> "Integer doubled: ${value * 2}"
    else -> "Other value: $value"
}
```

The `null` case is handled explicitly. Inside the `is String` branch, the compiler smart-casts `value` to `String`, so `length` is available without a manual cast.

### Subjectless `when`

```kotlin
fun deliveryFee(total: Int, isPremiumUser: Boolean): Int = when {
    total < 0 -> error("Total cannot be negative")
    isPremiumUser -> 0
    total >= 500 -> 0
    else -> 40
}
```

Without a subject, every branch is a Boolean condition. This is a readable alternative to a long `if`/`else if` chain. Order matters: the first true condition wins.

## Expected output

```text
Success
Client error
Text length: 6
Missing value
Delivery fee: 40
```

## Important behavior

- Branches are checked from top to bottom.
- Only the first matching branch executes.
- There is no implicit fall-through.
- A branch can contain a block; its final expression becomes that branch's value.
- When a `when` result is used, the compiler must be able to prove that every possible case produces a value.
- `else` supplies a fallback when the subject's possible values are not closed and fully known.
- Exhaustive `when` over enums and sealed hierarchies can omit `else` when every case is covered.

## Exhaustiveness

An expression must return a value on every path:

```kotlin
fun label(number: Int): String = when (number) {
    0 -> "zero"
    else -> "non-zero"
}
```

For an unrestricted `Int`, the compiler cannot list every value, so an `else` branch is required.

With a closed type such as an enum or sealed hierarchy, handling every known case can make the expression exhaustive without `else`. This is valuable because adding a new case can produce a compile-time reminder at all exhaustive `when` expressions.

Do not add `else` automatically to a closed hierarchy: it can hide a newly introduced case that deserves explicit handling.

## Matching forms

### Multiple values

```kotlin
when (day) {
    6, 7 -> "Weekend"
    else -> "Weekday"
}
```

### Ranges and collections

```kotlin
when (score) {
    in 90..100 -> "A"
    in 75..<90 -> "B"
    else -> "Needs improvement"
}
```

### Type checks with smart casts

```kotlin
when (value) {
    is String -> value.length
    is List<*> -> value.size
    else -> 0
}
```

### Arbitrary conditions

```kotlin
when {
    user == null -> "Sign in"
    !user.isActive -> "Account disabled"
    else -> "Welcome"
}
```

## Common mistakes

- Putting a broad branch before a narrow one, making the narrow branch unreachable in practice.
- Forgetting `else` when the expression is not otherwise exhaustive.
- Expecting Java-style fall-through.
- Adding an `else` to an enum or sealed hierarchy and thereby hiding future cases.
- Performing unrelated side effects in branches instead of returning a clear result.
- Repeating the same expensive calculation in several branch conditions.

## `when` versus `if`

Use `if` for one or two simple Boolean alternatives. Use `when` when several related cases are easier to scan as branches, especially value, type, range, enum, or sealed-hierarchy cases.

Both are expressions in Kotlin. Choose the form that makes the decision table easiest to understand.

## Kotlin compared with Java

Kotlin `when` is broader than Java's traditional `switch`: it supports arbitrary types, ranges, type checks, smart casts, and subjectless Boolean conditions. It also avoids fall-through by design.

Modern Java switch expressions share some expression-oriented behavior, but Kotlin `when` remains integrated with Kotlin smart casts and sealed-type exhaustiveness.

## Android relevance

`when` is common for converting domain or UI state into rendering decisions:

- Mapping network status to a UI message.
- Rendering loading, content, empty, and error states.
- Handling user actions or navigation destinations.
- Mapping HTTP codes or validation results.

Keep branches fast and side-effect-light in UI rendering code. State transitions are often clearer when `when` returns a new immutable state.

## Interview questions and answers

### 1. Is `when` a statement or an expression?

It is an expression and can produce a value. It can also be used where its result is ignored.

### 2. Does Kotlin `when` fall through like a Java `switch`?

No. Only the first matching branch executes, and no `break` is required.

### 3. When is `else` required?

When the result is needed and the listed branches are not exhaustive. An unrestricted type such as `Int` usually needs `else`.

### 4. When can `else` be omitted?

When the compiler can prove all possibilities are covered, such as all Boolean values, all enum constants, or all direct cases of an eligible sealed hierarchy.

### 5. Why can omitting `else` be useful for sealed classes or enums?

If a new case is added, the compiler identifies `when` expressions that must be updated. A broad `else` would hide that maintenance signal.

### 6. What is a subjectless `when`?

`when` without parentheses after it. Every branch contains a Boolean condition, making it similar to an `if`/`else if` chain.

### 7. How do smart casts work in a type branch?

After `is String` succeeds, the compiler treats a stable value as `String` within that branch, so its members can be accessed without an explicit cast.

### 8. What happens when several branches could match?

Branches are evaluated in source order, and the first match wins. Put specific or higher-priority conditions before broad ones.

### 9. Can a branch contain multiple statements?

Yes. Use a block; if the `when` produces a value, the block's final expression is the branch result.

## Practice

- Predict the output before running the example.
- Pass 503, 302, an `Int`, and a `Double` through the example functions.
- Reverse the premium-user and total branches in `deliveryFee` and decide whether behavior changes.
- Add a 300–399 redirect branch to `httpMessage`.
- Explain why placing `in 400..599` before `in 400..499` changes which result a 404 receives.
