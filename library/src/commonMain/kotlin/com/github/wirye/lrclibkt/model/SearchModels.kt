package com.github.wirye.lrclibkt.model

import kotlinx.serialization.Serializable

@Serializable
data class LrclibTrack(
    val id: Long,
    val trackName: String,
    val artistName: String,
    val albumName: String?,
    val duration: Double?,
    val instrumental: Boolean,
    val plainLyrics: String?,
    val syncedLyrics: String?
)