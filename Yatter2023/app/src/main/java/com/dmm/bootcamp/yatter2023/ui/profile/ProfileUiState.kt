package com.dmm.bootcamp.yatter2023.ui.profile

import com.dmm.bootcamp.yatter2023.domain.model.Me

data class ProfileUiState(
    val me: Me? = null,
    val isLoading: Boolean = false
){
    companion object {
        fun empty(): ProfileUiState = ProfileUiState()
    }
}
