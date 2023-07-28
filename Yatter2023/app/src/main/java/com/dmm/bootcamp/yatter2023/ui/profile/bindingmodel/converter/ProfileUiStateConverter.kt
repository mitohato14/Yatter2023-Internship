package com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.converter

import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.ProfileUiState

object ProfileUiStateConverter {

    fun convertToProfileUiState(me: Me?): ProfileUiState = ProfileUiState(
        me = me,
        isLoading = false
    )
}