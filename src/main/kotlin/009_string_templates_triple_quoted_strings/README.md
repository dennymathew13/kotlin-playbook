# 009 — String Templates and Triple-Quoted Strings

String templates insert values into text. Triple-quoted strings make multi-line text easier to write.

## String templates

Use `$name` for one variable and `${expression}` for an expression:

```kotlin
val name = "Maya"
val lessons = 3

println("$name completed $lessons lessons.")
// Maya completed 3 lessons.

println("Next lesson: ${lessons + 1}")
// Next lesson: 4
```

## Triple-quoted strings

```kotlin
val message = """
    Kotlin keeps line breaks.
    Triple-quoted strings need no " escaping.
""".trimIndent()
```

Triple-quoted strings preserve line breaks and treat backslashes as ordinary characters. `trimIndent()` removes the shared leading indentation.

## Important rules

- `$variable` inserts a simple name.
- `${expression}` evaluates and inserts an expression.
- Triple-quoted strings may span several lines.
- Escape sequences such as `\n` are not interpreted inside triple quotes.
- String templates still work inside triple-quoted strings.

## Common mistakes

- Omitting braces around a calculation or member access.
- Expecting `\n` to create a line break inside a raw string.
- Forgetting `trimIndent()` when source indentation should not appear.

## Interview questions

**When are braces required in a template?** For expressions beyond a simple variable name.

**What is a raw string?** A triple-quoted string that can span lines and does not process normal escape sequences.

**What does `trimIndent()` do?** It removes common leading indentation from nonblank lines.

## Quick revision

- `$name` inserts a variable.
- `${value + 1}` inserts an expression.
- `"""..."""` creates a raw multi-line string.
- `trimIndent()` cleans source indentation.

## Source code

[StringTemplates.kt](./StringTemplates.kt)

## Next lesson

010 — While Loop
