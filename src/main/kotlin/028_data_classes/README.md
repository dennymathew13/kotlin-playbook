# Data Classes

A data class is a class whose main purpose is to hold data with value-based behavior. The `data` modifier asks the compiler to generate common functions from properties declared in the primary constructor.

Data classes reduce boilerplate for domain models, UI state, API models, database rows, configuration, and test data.

## Runnable example

[DataClasses.kt](./DataClasses.kt)

## Declaration syntax

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
) {
    var stock: Int = 0
}
```

| Syntax | Meaning |
|---|---|
| `data class` | Requests compiler-generated value-oriented members. |
| `val id: Int` | Primary-constructor property included in generated members. |
| `var stock` in the body | Ordinary property excluded from generated data-class members. |
| `product.copy(price = 450)` | Creates a new instance while replacing selected constructor values. |

## Generated members

For primary-constructor properties, the compiler generates:

- `equals(other)` for structural equality.
- `hashCode()` consistent with `equals`.
- `toString()` containing the class name and constructor-property values.
- `component1()`, `component2()`, and so on, in constructor order.
- `copy(...)` with defaults taken from the current object.

The compiler does not generate these members from properties declared only in the class body.

## Step-by-step walkthrough

1. `firstProduct` is created from three constructor properties.
2. Its body property `stock` changes to 10.
3. `toString()` prints only `id`, `name`, and `price`.
4. `sameProduct` has the same constructor-property values but retains stock 0.
5. The two objects compare equal because `stock` is excluded from generated equality.
6. Equal objects also produce equal hash codes.
7. `copy(price = 450)` creates a distinct `Product` with a new price.
8. The body property is not copied, so the new product's stock remains its initializer value 0.

## Expected output

```text
Product(id=1, name=Phone, price=500)
Products are equal: true
Hash codes are equal: true
Original: Product(id=1, name=Phone, price=500)
Copy: Product(id=1, name=Phone, price=450)
Original stock: 10, copy stock: 0
```

## Structural versus referential equality

```kotlin
val first = Product(1, "Phone", 500)
val second = Product(1, "Phone", 500)

first == second  // true: calls generated equals
first === second // false: different object references
```

`==` is Kotlin structural equality and safely delegates to `equals`. `===` checks whether both references point to the same object.

## Constructor properties define data identity

Only primary-constructor properties participate in generated equality, hashing, string representation, components, and copying.

This is a design decision, not merely a syntax detail. If `stock` is part of a product's logical value, it should usually be a constructor property. Keeping it in the body means two products with different stock can still compare equal.

## `copy` is shallow

`copy` creates a new outer object, but it does not recursively clone referenced objects:

```kotlin
data class Cart(val items: MutableList<String>)

val original = Cart(mutableListOf("Phone"))
val copied = original.copy()
copied.items += "Case"

println(original.items) // [Phone, Case]
```

Both instances refer to the same mutable list. Prefer immutable/read-only values in data classes, or explicitly copy mutable nested data when independent state is required.

## Equality and `hashCode`

The core contract is:

- If `a == b`, then `a.hashCode() == b.hashCode()` must be true.
- Unequal objects may still have the same hash code.
- Mutating a constructor property used by equality while the object is a hash-map key or hash-set element can make lookup unreliable.

Prefer `val` constructor properties for stable value objects.

### Array property trap

Arrays use reference-based `equals` unless content helpers are called. A data class containing an array therefore does not automatically gain content-based array equality:

```kotlin
data class Payload(val bytes: ByteArray)

Payload(byteArrayOf(1)) == Payload(byteArrayOf(1)) // false
```

Use an appropriate immutable value representation or implement equality deliberately when array contents define identity.

## Data-class requirements and restrictions

- The primary constructor must have at least one parameter.
- Every primary-constructor parameter must be marked `val` or `var`.
- A data class cannot be `abstract`, `open`, `sealed`, or `inner`.
- A data class may implement interfaces.
- A data class may extend another class when normal constructor rules allow it.
- Explicit implementations or inherited final implementations can affect which generated members are available.

## `copy` is not mutation

```kotlin
val original = Product(1, "Phone", 500)
val discounted = original.copy(price = 450)
```

The original remains unchanged. This works well with immutable state because a changed value becomes a new object rather than an in-place update.

However, `copy` does not enforce business rules automatically. If some combinations of values are invalid, validate them in construction or expose a domain operation that preserves invariants.

## Common mistakes

- Assuming body properties participate in generated equality or copying.
- Assuming `copy` performs a deep copy.
- Using mutable constructor properties in hash-based collections.
- Putting passwords, tokens, or personal data in constructor properties without considering generated `toString()` and logs.
- Treating every class as a data class even when identity and behavior matter more than value.
- Using a data class solely to obtain shorter syntax when generated semantics are inappropriate.

## Data class versus regular class

| Data class | Regular class |
|---|---|
| Value-oriented generated members. | Reference equality unless `equals` is implemented. |
| Convenient `copy` and components. | Behavior and identity can be designed explicitly. |
| Ideal for transparent data models. | Better when lifecycle or identity dominates. |

## Kotlin compared with Java

A Kotlin data class replaces much of the boilerplate for fields, constructor, accessors, `equals`, `hashCode`, `toString`, and copy-like creation. Java records offer similar value-carrier goals but have different inheritance, component, and mutability rules.

Java callers see generated JVM methods, but Kotlin's named arguments and `copy` call style are Kotlin source features.

## Android relevance

Data classes are common for:

- Immutable ViewModel and Compose UI state.
- Network and database transfer models.
- Domain values and reducer results.
- Recycler/list items where meaningful equality supports diffing.
- Test fixtures and expected values.

Keep UI state deeply immutable where practical. A `val` containing a mutable list can still change without producing a new state object, which can make rendering and change detection unpredictable.

Avoid sensitive primary-constructor values when objects may be logged because generated `toString()` includes those values.

## Interview questions and answers

### 1. What does the `data` modifier generate?

`equals`, `hashCode`, `toString`, `componentN` functions, and `copy`, based primarily on primary-constructor properties.

### 2. Are properties declared in the class body included?

No. Generated equality, hashing, string output, components, and copying use primary-constructor properties.

### 3. Is `copy` a deep copy?

No. It creates a new outer instance but reuses referenced property values unless replacements are supplied.

### 4. Does `val` make a data class deeply immutable?

No. It prevents property reassignment through that reference, but referenced objects such as mutable lists can still change.

### 5. Why must equal objects have equal hash codes?

Hash-based collections first locate a bucket using the hash code and then use equality. Violating the contract breaks reliable lookup.

### 6. What is the difference between `==` and `===` for data classes?

`==` invokes structural equality; `===` checks reference identity.

### 7. Why prefer `val` properties in a data class?

Stable values are safer in hash collections, easier to reason about, and work naturally with `copy`-based immutable state updates.

### 8. Can a data class extend another class?

Yes, subject to normal inheritance rules, but a data class itself cannot be `open`. It may also implement interfaces.

### 9. What is dangerous about generated `toString()`?

It includes primary-constructor values. Logging the object can expose secrets or personal data.

### 10. Why might two data classes containing equal-looking arrays compare unequal?

Generated equality calls the array property's `equals`, which is reference-based for JVM arrays. Use content-aware design when array contents define value equality.

### 11. When should you not use a data class?

When object identity, encapsulated behavior, lifecycle, or custom equality semantics matter more than transparent value representation.

## Practice

- Move `stock` into the primary constructor and predict every changed output line.
- Compare two products with `==` and `===`.
- Add a mutable list property, call `copy`, and explain the shared-reference behavior.
- Use a product as a map key, then explain why mutable equality properties would be dangerous.
