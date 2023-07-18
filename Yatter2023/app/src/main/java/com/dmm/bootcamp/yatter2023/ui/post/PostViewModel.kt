package com.dmm.bootcamp.yatter2023.ui.post

import androidx.lifecycle.ViewModel
import com.dmm.bootcamp.yatter2023.domain.service.GetMeService
import com.dmm.bootcamp.yatter2023.usecase.post.PostStatusUseCase

class PostViewModel(
  private val postStatusUseCase: PostStatusUseCase,
  private val getMeService: GetMeService,
) : ViewModel()