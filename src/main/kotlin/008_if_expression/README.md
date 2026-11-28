# 008 — `if` Expression

`if` chooses code based on a Boolean condition. In Kotlin it is also an expression, so it can directly produce a value.

## Basic syntax

```kotlin
val score = 82
val result = if (score >= 80) "Pass" else "Try again"

println(result) // Pass
```

Because the result is assigned, both the `if` and `else` branches provide a compatible value.

Branches can contain several statements. The final expression is the branch value:

```kotlin
val discount = if (score >= 90) {
    20
} else {
    10
}

println(discount) // 10
```

## Important rules

- The condition must be `Boolean`.
- Kotlin does not treat numbers or objects as truthy or falsy.
- When `if` produces a value, an `else` branch is normally required.
- A block's final expression becomes that branch's value.
- Use `if` for simple Boolean choices and `when` for many related cases.

## Common mistakes

- Writing `if (number)` instead of a Boolean comparison.
- Forgetting `else` when assigning the result.
- Adding unnecessary mutable variables instead of using the expression result.

## Interview questions

**Is `if` an expression in Kotlin?** Yes. It can return a value.

**What is a branch block's value?** Its final expression.

**Must a condition be Boolean?** Yes.

## Quick revision

- `if (condition) value else otherValue` produces a value.
- Conditions are strictly Boolean.
- The selected branch alone runs.
- Prefer direct assignment from `if` when appropriate.

## Source code

[ConditionalExpression.kt](./ConditionalExpression.kt)

## Next lesson

009 — String Templates and Triple-Quoted Strings
