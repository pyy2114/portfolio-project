package com.yoon.portfolio.presentation.dto

import com.yoon.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction): this(
        content = introduction.content
    )
}