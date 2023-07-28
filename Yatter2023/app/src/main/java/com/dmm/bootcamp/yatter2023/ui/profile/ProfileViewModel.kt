package com.dmm.bootcamp.yatter2023.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.model.AccountId
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.domain.service.GetMeService
import com.dmm.bootcamp.yatter2023.infra.domain.model.MeImpl
import com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.ProfileUiState
import com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.converter.ProfileUiStateConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.URL

class ProfileViewModel(
    private val getMeService: GetMeService
) : ViewModel() {
    private val _uiState : MutableStateFlow<ProfileUiState> = MutableStateFlow(ProfileUiState.empty())
    val uiState : StateFlow<ProfileUiState> = _uiState

    fun onResume(){
        viewModelScope.launch {
            val me = MeImpl(
                AccountId("@mori"),
                Username("mori-yukihiro"),
                "DMM Android InternShip",
                "DMM Android 2023 インターンシップ",
                URL("https://iconbu.com/wp-content/uploads/2023/06/%E3%82%B5%E3%83%B3%E3%82%B0%E3%83%A9%E3%82%B9%E3%81%86%E3%81%95%E3%81%8E%E3%81%95%E3%82%93.jpg"),
                URL("https://img.freepik.com/free-vector/abstract-star-seamless-on-brown-background_271628-982.jpg?w=1060&t=st=1690525518~exp=1690526118~hmac=b0a23254f80514476b37a57b441a2240f33fd85af4a963a9ae8daaecbd52c80d"),
            43,
            128,
            )
            /*getMeService.execute()*/
            _uiState.value = ProfileUiStateConverter.convertToProfileUiState(me)
        }
    }
}