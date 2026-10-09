# lrclib-kt

Kotlin-библиотека для работы с API Lrclib.
Не связана с Lrc

Обновляется по мере развития моего приложения Garden, если тут чего-то нету, то оно скоро будет

# Установка

```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositories { maven("https://jitpack.io") }
}

// build.gradle.kts
dependencies {
    implementation("com.github.Wirye:lrclibkt-kt:1.0.1")
}
```

# Быстрый старт

```kotlin
val client = LrclibClient(userAgent = "MyApp/1.0.0 ( me@example.com )")

client.search.searchById(33510328)
    .onSuccess { result -> println("Token: $result") }
    .onFailure { exception -> println("Exception: $exception") }
```

Клиент создаётся один раз. В нём:

- `client.search` - поиск
- Также есть функция decipherSyncedLyrics для автоматической расшифровки синхронизированных текстов в понятный List<Pair<Duration, String>>

## Ошибки

Все функции возвращают `Result<T>`, а исключения приходят в `Result.failure`

- `NotFoundException` - Ничего не найдено
- `ValidationErrorException(message)` - неверный запрос, текст от сервера
- `ServerErrorException(code)` - ошибка сервера, код `503` обычно значит превышение лимита запросов

## Данные и лицензии

Обычно всё открыто, но рекомендую проверять правила
