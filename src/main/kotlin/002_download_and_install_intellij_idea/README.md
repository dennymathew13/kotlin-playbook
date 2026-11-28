# 002 — Download and Install IntelliJ IDEA

IntelliJ IDEA provides Kotlin editing, code completion, Gradle support, and a run action for each `main` function.

## Setup

1. Install a current IntelliJ IDEA release from JetBrains.
2. Install JDK 21 if it is not already available.
3. Open this repository as a Gradle project.
4. Allow Gradle to finish importing.
5. Open a lesson's Kotlin file and run its `main` function.

The repository includes the Gradle wrapper, so a separate Gradle installation is not required.

## Verify from the terminal

On Windows:

```powershell
.\gradlew.bat build
```

On macOS or Linux:

```bash
./gradlew build
```

A successful build confirms that the JDK and project configuration are working.

## Common problems

- **Wrong JDK:** set the project and Gradle JVM to JDK 21.
- **Gradle import still running:** wait for synchronization to finish before running code.
- **Wrapper not executable on macOS/Linux:** run `chmod +x gradlew` once.

## Quick revision

- Open the repository as a Gradle project.
- Use JDK 21.
- Run examples from their `main` functions.
- Use the included Gradle wrapper for builds.

## Next lesson

003 — Hello World
