package com.dmm.bootcamp.yatter2023.ui.login

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity() {
  companion object {
    fun newIntent(context: Context): Intent = Intent(
      context,
      LoginActivity::class.java,
    )
  }

  private val viewModel: LoginViewModel by viewModel()

}