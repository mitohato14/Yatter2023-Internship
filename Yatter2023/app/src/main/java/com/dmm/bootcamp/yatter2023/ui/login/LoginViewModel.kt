package com.dmm.bootcamp.yatter2023.ui.login

import androidx.lifecycle.ViewModel
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCase

internal class LoginViewModel(
  private val loginUseCase: LoginUseCase,
) : ViewModel()