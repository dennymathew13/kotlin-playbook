# 013 — Expressions and Statements

An expression produces a value. A statement performs an action or declaration but does not produce a value that can be assigned.

## Expressions

Kotlin's `if` can produce a value:

```kotlin
val score = 82
val grade = if (score >= 80) "A" else "B"

println(grade) // A
```

The selected branch becomes the value of the whole `if` expression. Both branches are needed when the result is used.

## Statements

Variable declarations and assignments are statements:

```kotlin
var nextScore = score
nextScore = 83

// val result = (score = 90) // Compile-time error
```

Assignment does not return its assigned value. This prevents accidental assignment where a Boolean condition is expected.

## Important rules

- Literals, calculations, and function calls can be expressions.
- `if`, `when`, and `try` can produce values.
- Assignments and declarations are statements.
- Loops do not produce a useful result value.
- Prefer directly computing a value over creating unnecessary mutable temporary state.

## Interview questions

**What is an expression?** Code that evaluates to a value.

**Is assignment an expression in Kotlin?** No.

**Can `if` initialize a variable?** Yes, when every path produces the required value.

## Quick revision

- Expression: produces a value.
- Statement: performs an action without a usable value.
- `if` can be an expression.
- Assignment is a statement.

## Source code

[ExpressionBasics.kt](./ExpressionBasics.kt)

## Next lesson

014 — Classes
