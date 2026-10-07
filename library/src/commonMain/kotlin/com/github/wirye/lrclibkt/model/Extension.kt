package com.github.wirye.lrclibkt.model

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

fun decipherSyncedLyrics(syncedLyrics: String): List<Pair<Duration, String>> {
    val res = syncedLyrics.split("\n").map { string ->
        val spl1 =  string.removeRange(0..string.indexOfFirst { it.toString() == "[" })
        val spl2 = spl1.removeRange(spl1.indexOfFirst { it.toString() == "]" }..spl1.lastIndex)
        val spl3 = string.removeRange(0..string.indexOfFirst { it.toString() == "]" }+1.coerceIn(0, string.length-1)).ifBlank { "🎵" }

        Pair(spl2.toDuration(), spl3)
    }

    return res
}

fun String.toDuration(): Duration {
    val parts = this.split(":")
    return when (parts.size) {
        2 -> {
            val minutes = parts[0].toLong().minutes
            val seconds = parts[1].toDouble().seconds
            minutes + seconds
        }
        3 -> {
            val hours = parts[0].toLong().hours
            val minutes = parts[1].toLong().minutes
            val seconds = parts[2].toDouble().seconds
            hours + minutes + seconds
        }
        else -> throw IllegalArgumentException("Некорректный формат таймкода: $this")
    }
}