# Data Types

A type defines which values a name can hold and which operations are valid. The example covers common numeric, character, text, and Boolean types plus explicit numeric conversion.

## Runnable example

[DataTypes.kt](./DataTypes.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `Int / Long` | Signed whole-number types; a `Long` literal commonly uses `L`. |
| `Float / Double` | Floating-point types; a `Float` literal uses `F`. |
| `Char / String` | One UTF-16 code unit versus a sequence of characters. |
| `Boolean` | Either `true` or `false`. |
| `toLong()` | Performs an explicit numeric conversion. |
| `_ in numbers` | Digit separators improve readability and do not change the value. |

## Step-by-step walkthrough

1. The explicit annotations document each intended type.
2. `quantity * price` produces a `Double` because one operand is `Double`.
3. `quantity.toLong()` explicitly widens the `Int`.
4. Assigning an `Int` directly to `Long` is rejected.

## Expected output

```text
K order 9000000000: 59.97, available=true, rating=4.5
3
```

## Important rules and behavior

- Kotlin does not implicitly widen numeric variables.
- Integer division discards the remainder when both operands are integers.
- `Double` is the default floating-point literal type.
- On the JVM, Kotlin may use primitives or boxed values depending on context.
- Floating-point values are unsuitable for exact money calculations.

## Common mistakes and edge cases

- Expecting `Int` to assign automatically to `Long`.
- Using `Double` for exact currency without understanding rounding.
- Assuming `Char` is a one-character `String`.

## Kotlin compared with Java

Unlike Java, Kotlin deliberately rejects implicit numeric widening between variables. Kotlin presents types uniformly although JVM bytecode may use primitives.

## Android relevance

Use `Long` for timestamps and large identifiers, `Float` where graphics APIs require it, and exact decimal/integer representations for money.

## Interview questions and answers

### 1. Why does Kotlin reject `val x: Long = intValue`?

Explicit conversion prevents silent precision and overload-resolution surprises.

### 2. Is `Int` always a boxed object on the JVM?

No. Kotlin commonly emits primitive `int`; boxing occurs when required, such as nullable or generic contexts.

### 3. Why can `0.1 + 0.2` be surprising?

Binary floating point cannot represent many decimal fractions exactly.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
