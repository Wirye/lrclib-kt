package com.github.wirye.lrclibkt.exception

sealed class LrclibException(message: String) : Exception(message) {
    class ValidationErrorException(message: String) : LrclibException("Ошибка валидации (неверный формат данных) $message")
    class ServerErrorException(code: Int) : LrclibException("Ошибка сервера (код $code)")
    class NotFoundException : LrclibException("Ничего не найдено")
}
