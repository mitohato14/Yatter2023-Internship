package com.dmm.bootcamp.yatter2023.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun ProfilePage(viewModel: ProfileViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    
    ProfilePageTemplate(uiState = uiState)
}