# Default and Named Arguments

Default arguments make parameters optional, while named arguments document which value belongs to which parameter.

## Runnable example

[DefaultandNamedArguments.kt](./DefaultandNamedArguments.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `role: String = "viewer"` | Declares a default value. |
| `name = "Arun"` | Supplies a named argument. |
| `createUser("Maya")` | Uses defaults for omitted arguments. |

## Step-by-step walkthrough

1. The first call uses both defaults.
2. The second overrides `active` while retaining the default role.
3. The third supplies named arguments in a different order.

## Expected output

```text
Maya (viewer), active=true
Arun (viewer), active=false
Lee (admin), active=true
```

## Important rules and behavior

- Defaults are evaluated when the call is made.
- Named arguments improve clarity for Boolean and same-typed parameters.
- After using a named argument, follow the language rules carefully when mixing positional arguments.
- Renaming a public parameter can break Kotlin callers that use its name.

## Common mistakes and edge cases

- Creating many overloads where defaults are clearer.
- Using positional Boolean arguments that hide meaning.
- Expecting Java callers to understand Kotlin named arguments.

## Kotlin compared with Java

Java has no language-level named/default arguments. Java-facing APIs may need overloads, builders, or `@JvmOverloads` where appropriate.

## Android relevance

Defaults work well for UI helpers and test fixtures, but avoid functions with a long list of configuration parameters.

## Interview questions and answers

### 1. Can Java use Kotlin default arguments directly?

Not with Kotlin call syntax; expose suitable overloads or a Java-friendly API.

### 2. Are parameter names part of an API?

For Kotlin source callers using named arguments, effectively yes.

### 3. Why are named Boolean arguments useful?

`load(forceRefresh = true)` communicates intent better than `load(true)`.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
