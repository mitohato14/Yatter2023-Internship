package com.dmm.bootcamp.yatter2023.ui.profile

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.model.AccountId
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.domain.model.Password
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.domain.repository.AccountRepository
import com.dmm.bootcamp.yatter2023.domain.service.GetMeService
import com.dmm.bootcamp.yatter2023.domain.service.LoginService
import com.dmm.bootcamp.yatter2023.infra.domain.model.MeImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.URI
import java.net.URL

internal class ProfileViewModel(
    private val getMeService: GetMeService
) : ViewModel() {
    private val _uiState: MutableStateFlow<ProfileUiState> =
        MutableStateFlow(ProfileUiState.empty())
    val uiState: StateFlow<ProfileUiState> = _uiState

    init {
        onResume()
    }

    fun onResume() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            fetchProfile()
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private suspend fun fetchProfile() {
        val me = MeImpl(
            AccountId("@mori"),
            Username("@mori"),
            "DMM のんびり猫",
            "よろしくお願いします。",
            URL("https://iconbu.com/wp-content/uploads/2022/06/%E3%82%AF%E3%83%AC%E3%83%BC%E3%83%97%E3%81%A8%E7%8C%AB%E3%81%95%E3%82%935.jpg"),
            URL("https://img.freepik.com/free-vector/watercolor-background_220290-47.jpg?w=1800&t=st=1690522869~exp=1690523469~hmac=50d83ecb4d2414d5fff1f5bcfd74abff283cd1a151690e1ce04030ff2792c067"),
            30,
            128,
        )
        _uiState.update { it.copy(me = me) }
    }
}