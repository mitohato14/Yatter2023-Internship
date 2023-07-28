package com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel

import com.dmm.bootcamp.yatter2023.domain.model.Me

data class ProfileUiState(
    val me: Me?,
    val isLoading: Boolean
) {
    companion object {
        fun empty(): ProfileUiState = ProfileUiState(
            me = null,
            isLoading = false
        )
    }
}