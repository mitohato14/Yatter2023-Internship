package com.dmm.bootcamp.yatter2023.ui.post

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostActivity : AppCompatActivity() {
  companion object {
    fun newIntent(context: Context): Intent = Intent(
      context,
      PostActivity::class.java,
    )
  }

  private val viewModel: PostViewModel by viewModel()

}