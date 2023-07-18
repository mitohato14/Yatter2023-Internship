package com.dmm.bootcamp.yatter2023.ui.timeline

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PublicTimelineActivity : AppCompatActivity() {
  companion object {
    fun newIntent(context: Context): Intent = Intent(
      context,
      PublicTimelineActivity::class.java,
    )
  }

  private val viewModel: PublicTimelineViewModel by viewModel()

}