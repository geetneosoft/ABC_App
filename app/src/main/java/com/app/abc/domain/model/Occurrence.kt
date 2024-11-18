package com.app.abc.domain.model

data class Occurrence (
    val itemCount: Int,
    val characterOccurrences: Map<Char, Int>
)