# Overloading

Overloading means declaring several functions with the same name but different parameter lists. It lets one clear operation name support different kinds or amounts of input while preserving compile-time type safety.

Use overloading when the functions represent the same idea. If two functions perform unrelated work, different names communicate intent better.

## Runnable example

[Overloading.kt](./Overloading.kt)

## Syntax

```kotlin
fun findOrder(orderId: Int): String = "Order number: $orderId"

fun findOrder(reference: String): String = "Order reference: $reference"

fun findOrder(orderId: Int, includeItems: Boolean): String = ...
```

All three functions are named `findOrder`, but their signatures differ by parameter type or parameter count.

| Call | Selected overload | Reason |
|---|---|---|
| `findOrder(42)` | `findOrder(Int)` | The argument has type `Int`. |
| `findOrder("WEB-42")` | `findOrder(String)` | The argument has type `String`. |
| `findOrder(42, true)` | `findOrder(Int, Boolean)` | Two arguments were supplied. |

The compiler selects an overload at compile time. This is also called static or compile-time polymorphism.

## Step-by-step walkthrough

1. `findOrder(42)` selects the overload whose parameter is `Int`.
2. `findOrder("WEB-42")` selects the `String` overload.
3. The named two-argument call selects `findOrder(Int, Boolean)`.
4. `describe("Kotlin")` selects `describe(String)` because the expression is declared as a `String`.
5. `language` contains a `String` object, but its declared type is `Any`.
6. `describe(language)` therefore selects `describe(Any)`. Overload selection does not switch at runtime based on the object's more specific type.

## Expected output

```text
Order number: 42
Order reference: WEB-42
Order number: 42 with items
String with 6 characters
Any: Kotlin
```

## What can form a different overload?

Functions can be overloaded using:

- A different number of parameters.
- Different parameter types.
- A different order of parameter types.
- Generic and non-generic signatures when the compiler can distinguish them.

The return type alone is not enough:

```kotlin
// These cannot coexist.
fun load(id: Long): Int = 1
fun load(id: Long): String = "one"
```

The call `load(1L)` would not tell the compiler which function to invoke. This is a compile-time declaration conflict.

## Overload resolution rules to know

- Resolution uses the number, declared types, and names of arguments available at the call site.
- The most specific applicable overload is normally preferred.
- Kotlin does not use the expected return type to distinguish functions with identical parameter lists.
- Runtime object type does not provide virtual dispatch between top-level overloads.
- Member overriding and function overloading are different mechanisms.
- Numeric types do not implicitly widen, so an `Int` argument does not silently become `Long` to find an overload.
- `null` can make calls ambiguous when several unrelated nullable parameter types are applicable.

### Declared type versus runtime type

```kotlin
fun describe(value: Any) = "Any"
fun describe(value: String) = "String"

val first = "Kotlin"
val second: Any = "Kotlin"

describe(first)  // String overload
describe(second) // Any overload
```

The object stored in both variables is a `String`, but overload resolution sees the variables' compile-time types.

## Defaults and overloads

Default arguments already reduce the need for overloads:

```kotlin
fun load(id: Int, refresh: Boolean = false) = Unit
```

Avoid adding overloads whose calls overlap confusingly with default parameters. Prefer one well-designed function unless overloads materially improve the API or are required for Java interoperability.

`@JvmOverloads` can generate JVM overloads for Java callers, but it should be introduced deliberately in a later Java-interoperability lesson. It is not necessary for ordinary Kotlin callers.

## Common mistakes

- Believing functions can differ only by return type.
- Expecting runtime dispatch to choose a more specific top-level overload.
- Creating many overloads that have subtly different behavior.
- Combining defaults, nullable arguments, and overloads until a call becomes ambiguous.
- Using overloads for unrelated operations simply because their names sound similar.

## Overloading versus overriding

| Overloading | Overriding |
|---|---|
| Same name, different parameter lists. | Same member signature in a subtype. |
| Usually resolved at compile time. | Uses runtime virtual dispatch. |
| Does not require inheritance. | Requires an inheritable member and subtype. |
| Models several input forms for one operation. | Replaces inherited behavior. |

## Kotlin compared with Java

Both languages support overloads. Kotlin adds default and named arguments, so many Java-style convenience overloads are unnecessary. Java cannot call Kotlin default arguments using Kotlin syntax; a Java-facing API may still expose explicit overloads.

Kotlin's strict numeric conversions also affect overload resolution: `Int` does not automatically widen to `Long` as it often can in Java.

## Android relevance

Android and Java APIs frequently expose overloaded methods and constructors. When designing Kotlin APIs:

- Prefer defaults and named arguments for Kotlin-only code.
- Use overloads when distinct input types genuinely represent the same action.
- Keep overload behavior consistent so callers do not need to memorize hidden differences.
- Be careful with nullable Android types because `null` may make an overload ambiguous.

## Interview questions and answers

### 1. What is function overloading?

Declaring multiple functions with the same name but different parameter lists. The compiler selects an applicable overload from the call-site argument information.

### 2. Is overloading compile-time or runtime polymorphism?

It is normally compile-time polymorphism. Overriding is the common runtime-polymorphism mechanism.

### 3. Can two functions be overloaded only by return type?

No. Calls are resolved from their arguments, so identical parameter lists produce a conflicting overload even when return types differ.

### 4. Which overload is called when a `String` object is stored in an `Any` variable?

The overload accepting `Any`, because overload resolution uses the expression's declared compile-time type.

### 5. How do default arguments affect overload design?

They often replace convenience overloads. Mixing overlapping overloads with defaults can produce confusing or ambiguous calls.

### 6. Why might Kotlin still use overloads for a Java-facing API?

Java does not support Kotlin's named and default argument syntax. Explicit overloads, or carefully applied `@JvmOverloads`, can provide a natural Java API.

### 7. What happens if `null` matches two overloads?

If neither nullable parameter type is more specific, the compiler reports overload-resolution ambiguity. Cast the value or redesign the API to express intent.

## Practice

- Predict each selected overload before running the example.
- Change `val language: Any` to `val language: String` and explain the output change.
- Add a `findOrder(Long)` overload and test it with `42`, `42L`, and `42.toLong()`.
- Explain why adding a second `findOrder(Long)` with only a different return type fails.
