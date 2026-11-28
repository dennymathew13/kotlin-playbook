# 018 — Packages and Imports

Packages group declarations into namespaces. Imports let a file use a declaration without writing its full package name.

## Package declaration

```kotlin
package lesson018.packagesimports
```

The package normally matches the source folder for easy navigation, although the Kotlin compiler does not require that match.

## Imports and aliases

```kotlin
import kotlin.math.roundToInt as rounded

fun main() {
    println(4.6.rounded()) // 5
}
```

`as rounded` gives the imported function a local alias. Aliases are useful when two imports have the same name, but familiar names should not be renamed without a reason.

## Important rules

- The package declaration appears before imports.
- Imports affect compile-time name lookup; they do not copy code.
- Kotlin can import top-level classes, functions, and properties.
- `*` imports declarations from one package, not its subpackages.
- Avoid unused imports and unclear aliases.

## Common mistakes

- Assuming folder placement alone declares a package.
- Giving files in the same lesson inconsistent package names.
- Using wildcard imports when explicit imports are clearer.

## Interview questions

**Must a package match its directory?** No, but matching is the normal convention.

**What does `as` do in an import?** It gives that declaration another name within the file.

**Do imports add runtime cost?** No.

## Quick revision

- `package` declares a namespace.
- `import` shortens references.
- `as` resolves a naming conflict or supplies a clear local name.
- Keep package and folder organization consistent.

## Source code

[PackageImports.kt](./PackageImports.kt)

## Next lesson

019 — Lists
