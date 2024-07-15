# Compose HTML library template
 
This is Kotlin/JS template projects using Compose HTML library for UI.

For more information read [article](https://habr.com)

## Getting started

- ### Run project

```shell
./gradlew composeApp:jsRun
```

## UI

Template uses compose multiplatform as ui library but only Runtime and Compose HTML library to draw ui.

#### This stack supports:
- Compose runtime functions
  - @Composable
  - State
  - Side-effects
  - and other from [compose-runtime module](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary)
- Compose HTML library
  - HTML tags in Kotlin like `Div`, `Button`, `TextArea`, `Span`.
  - CSS in Kotlin via `StyleSheet` and `style` attrs