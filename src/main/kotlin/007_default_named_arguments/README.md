# 007 — Default and Named Arguments

Default arguments make parameters optional at the call site. Named arguments make calls clearer and allow arguments to be supplied in a different order.

## Default argument

```kotlin
fun welcome(
    name: String,
    greeting: String = "Hello",
): String = "$greeting, $name!"

println(welcome("Denny")) // Hello, Denny!
```

The default is used only when the caller omits `greeting`.

## Named arguments

```kotlin
println(welcome(greeting = "Welcome", name = "Maya"))
// Welcome, Maya!
```

Names explain which value belongs to which parameter. They are especially helpful for Boolean values and several arguments of the same type.

## Important rules

- Default values belong in the function declaration.
- Named arguments use `parameterName = value`.
- Named arguments may be reordered.
- After using a named argument, keep later arguments named for clear, valid calls.
- Changing a public parameter name can break Kotlin callers that use it by name.

## Common mistakes

- Repeating default values manually at every call site.
- Using positional Boolean arguments that hide their meaning.
- Assuming Java callers can use Kotlin named arguments; Java cannot.

## Interview questions

**Why use default arguments?** They reduce repetitive overloads and call-site boilerplate.

**Why use named arguments?** They improve readability and allow reordering.

**Are parameter names part of a Kotlin source API?** Effectively yes when callers use named arguments.

## Quick revision

- `value: Type = default` declares a default.
- Omitted arguments use their defaults.
- `name = value` is a named argument.
- Defaults often replace convenience overloads.

## Source code

[FunctionArguments.kt](./FunctionArguments.kt)

## Next lesson

008 — `if` Expression
