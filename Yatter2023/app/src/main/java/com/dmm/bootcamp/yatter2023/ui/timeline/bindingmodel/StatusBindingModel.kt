package com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel

import com.dmm.bootcamp.yatter2023.domain.model.Media

data class StatusBindingModel(
    val id: String,
    val displayName: String,
    val username: String,
    val avatar: String?,
    val content: String,
    val attachmentMediaList: List<Media>
)