package com.dmm.bootcamp.yatter2023.ui.register

import androidx.lifecycle.ViewModel
import com.dmm.bootcamp.yatter2023.usecase.register.RegisterAccountUseCase

class RegisterAccountViewModel(
  private val registerAccountUseCase: RegisterAccountUseCase,
) : ViewModel()
