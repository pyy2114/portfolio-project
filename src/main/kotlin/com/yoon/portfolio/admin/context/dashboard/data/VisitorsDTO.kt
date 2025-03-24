package com.yoon.portfolio.admin.context.dashboard.data

import org.springframework.boot.ansi.AnsiBackground

data class VisitorsDTO(
    val name: String,
    val count: Long,
    val color: String,
    val background: String
)
