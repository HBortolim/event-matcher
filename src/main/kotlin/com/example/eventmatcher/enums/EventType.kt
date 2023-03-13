package com.example.eventmatcher.enums

import java.util.*

enum class EventType(name: String) {
    NONE("None"),
    GAMES("Games"),
    MUSIC("Music"),
    BOOKS("Books"),
    THEATER("Theater");

    companion object {
        fun fromString(value: String): EventType {
            return valueOf(value.uppercase(Locale.getDefault()))
        }
    }
}