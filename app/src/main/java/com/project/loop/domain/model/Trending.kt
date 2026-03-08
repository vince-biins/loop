package com.project.loop.domain.model

import com.project.loop.base.enums.Tags

data class Trending(
    val id: Int,
    val title: String,
    val reacts: String,
    val isTrend: Boolean,
    val tags: Tags
)
