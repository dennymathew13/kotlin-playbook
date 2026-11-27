# String Templates and Triple-Quoted Strings

String templates embed values and expressions directly in text. Triple-quoted raw strings preserve multiline content without normal backslash escaping.

## Runnable example

[StringTemplatesandTripleQuotedStrings.kt](./StringTemplatesandTripleQuotedStrings.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `$user` | Inserts a simple identifier. |
| `${items + 1}` | Evaluates and inserts an expression. |
| `"""..."""` | Creates a raw, possibly multiline string. |
| `trimIndent()` | Removes common leading indentation. |
| `${'$'}` | Represents a literal dollar sign when used as `${'$'}` in Kotlin source. |

## Step-by-step walkthrough

1. The first template computes `items + 1`.
2. The raw string spans two lines and still supports `$user`.
3. `${'$'}` produces a literal dollar sign.
4. `StringOperations.kt` adds immutable string transformations, splitting, searching, JSON-shaped raw text, and `buildString`.

## Expected output

```text
Maya has 4 items
GET /users/Maya
Accept: application/json
Price: $10
```

## Important rules and behavior

- Strings are immutable; operations return new strings.
- Raw strings disable backslash escaping but not templates.
- Use `${...}` for expressions and property access.
- `trimIndent` is a standard-library operation, not special syntax.

## Common mistakes and edge cases

- Assuming raw strings disable `$` interpolation.
- Using templates for localized Android UI text.
- Forgetting braces around a nontrivial expression.

## Kotlin compared with Java

Templates replace much string concatenation. Java commonly uses `+`, formatting APIs, or text blocks for multiline text.

## Android relevance

Templates are good for debugging and internal text; user-visible strings should generally use Android resources and placeholders for localization.

## Interview questions and answers

### 1. Are Kotlin strings mutable?

No. Operations such as `replace` return a new string.

### 2. Do raw strings process `\n` as a newline?

No; backslash escapes are literal in raw strings.

### 3. How do you insert an expression?

Use `${expression}`.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
