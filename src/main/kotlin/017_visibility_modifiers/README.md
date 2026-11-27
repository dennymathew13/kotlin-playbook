# Visibility Modifiers

Visibility controls which code can use a declaration. Small APIs reduce coupling and protect invariants.

## Runnable example

[VisibilityModifiers.kt](./VisibilityModifiers.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `public` | Visible everywhere; the default. |
| `private` | Visible within the declaring scope; top-level private is file-private. |
| `protected` | Visible in a class and subclasses; unavailable at top level. |
| `internal` | Visible within the same compilation module. |

## Step-by-step walkthrough

1. `Session` is visible within this module.
2. Its token is private to the class.
3. `maskedToken` exposes only the final two characters.
4. `DEFAULT_USER` is visible only in this file.

## Expected output

```text
guest: ***ef
```

## Important rules and behavior

- Kotlin has no Java-style package-private default.
- `internal` is a module boundary, not a runtime security boundary.
- On JVM, `internal` representation relies on compiler metadata/name handling.
- Use the narrowest visibility that supports required collaboration.

## Common mistakes and edge cases

- Treating `internal` as package-private.
- Treating visibility as protection for secrets at runtime.
- Making everything public "just in case."

## Kotlin compared with Java

Java's default is package-private; Kotlin's default is public. Kotlin `internal` spans a compilation module rather than a package.

## Android relevance

`internal` is useful inside Gradle modules; `private` remains the best choice for implementation details.

## Interview questions and answers

### 1. Is `internal` the same as Java package-private?

No. It is module-wide, independent of package.

### 2. Can a top-level declaration be `protected`?

No; protection is based on class inheritance.

### 3. Is `internal` a security boundary?

No. It is primarily a source/compiler visibility rule.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
