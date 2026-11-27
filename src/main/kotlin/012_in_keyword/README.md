# in Keyword

`in` expresses iteration and membership. Membership is convention-based: `value in container` is translated to a suitable `container.contains(value)` call.

## Runnable example

[inKeyword.kt](./inKeyword.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `x in values` | Tests membership. |
| `x !in values` | Tests non-membership. |
| `for (x in values)` | Iterates values. |
| `operator fun ...contains(...)` | Enables custom membership syntax. |

## Step-by-step walkthrough

1. The set contains `admin`.
2. 11 is not inside the closed range 1-10.
3. The custom `contains(String)` converts `"7"` and checks the numeric range.

## Expected output

```text
true
true
true
```

## Important rules and behavior

- The meaning of `in` depends on context.
- Membership syntax reverses the apparent receiver: `x in y` calls `y.contains(x)`.
- A custom operator should preserve unsurprising semantics.
- `in` later also appears in generic variance declarations.

## Common mistakes and edge cases

- Believing `in` only works with ranges.
- Writing a custom `contains` with surprising side effects.
- Forgetting that conversion can fail and must be handled.

## Kotlin compared with Java

Java uses explicit `contains` for membership and enhanced-for syntax for iteration.

## Android relevance

Useful for input validation, allowed actions, permission sets, and state-range checks.

## Interview questions and answers

### 1. What does `x in y` call?

A suitable `y.contains(x)` operator function.

### 2. What does `!in` do?

It negates the membership result.

### 3. Is `in` always membership?

No. It also appears in iteration and in generic variance syntax.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
