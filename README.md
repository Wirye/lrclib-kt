# lrclib-kt

Kotlin-библиотека для работы с API LRCLIB.
(Обновляется по мере развития моего приложения Garden, если тут чего-то нету, то оно скоро будет)

Чтобы начать работу создайте LrclibClient(), в нём находятся все функции, например для поиска текста песни - LrclibClient().search.searchByMeta(trackName, artist, album, duration) и так далее

ВАЖНО: При создании клиента библиотеки, желательно указывать осмысленный User-Agent

ОЧЕНЬ ВАЖНО: В httpClient указывайте json → ignoreUnknownKeys = true

(Из-за моей ошибки в названии репозитория теперь ссылка на jitpack выглядит так - https://jitpack.io/#Wirye/lrclibkt-kt/1.0.0)
