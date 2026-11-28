# 017 — Visibility Modifiers

Visibility modifiers control which code can use a declaration. Keeping implementation details hidden makes APIs smaller and safer to change.

## The four modifiers

- `public` — visible everywhere; this is the default.
- `private` — visible only in the declaring class or file.
- `protected` — visible in a class and its subclasses; not allowed at top level.
- `internal` — visible inside the same compilation module.

```kotlin
internal class Session(private val token: String) {
    fun maskedToken(): String = "***${token.takeLast(2)}"
}

private const val DEFAULT_USER = "guest"
```

`token` is accessible only inside `Session`. The top-level constant is accessible only inside its file.

```kotlin
println("$DEFAULT_USER: ${Session("abcdef").maskedToken()}")
// guest: ***ef
```

## Important rules

- Kotlin declarations are `public` by default.
- Top-level `private` means file-private.
- A class member marked `private` is visible only inside that class.
- `internal` means module-wide, not package-wide.
- Visibility is an API boundary, not protection for runtime secrets.

## Common mistakes

- Treating `internal` as Java package-private.
- Trying to use `protected` on a top-level declaration.
- Making every declaration public without a caller that needs it.

## Interview questions

**What is Kotlin's default visibility?** `public`.

**What does top-level `private` mean?** The declaration is visible only in that file.

**Is `internal` package-private?** No. It covers a compilation module.

**Can a top-level declaration be protected?** No.

## Quick revision

- Start with the narrowest useful visibility.
- `private` hides implementation details.
- `internal` shares within a module.
- `protected` is for class inheritance.

## Source code

[VisibilityModifiers.kt](./VisibilityModifiers.kt)

## Next lesson

018 — Packages and Imports
