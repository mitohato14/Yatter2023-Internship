package com.dmm.bootcamp.yatter2023.ui.timeline

import androidx.lifecycle.ViewModel
import com.dmm.bootcamp.yatter2023.domain.repository.StatusRepository

internal class PublicTimelineViewModel(
  private val statusRepository: StatusRepository,
) : ViewModel()