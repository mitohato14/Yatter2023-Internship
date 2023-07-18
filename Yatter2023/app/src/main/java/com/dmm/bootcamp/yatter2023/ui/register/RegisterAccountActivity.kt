package com.dmm.bootcamp.yatter2023.ui.register

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterAccountActivity : ComponentActivity() {
  companion object {
    fun newIntent(context: Context) = Intent(
      context,
      RegisterAccountActivity::class.java,
    )
  }

  private val viewModel: RegisterAccountViewModel by viewModel()

}
