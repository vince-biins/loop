package com.project.loop.presentation.main.explore.state

import com.project.loop.base.viewmodel.BaseState
import com.project.loop.domain.model.Trending

data class ExploreState(
    val trend: List<Trending>
) : BaseState()
