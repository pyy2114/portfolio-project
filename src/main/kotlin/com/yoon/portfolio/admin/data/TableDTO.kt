package com.yoon.portfolio.admin.data

data class TableDTO(
    val name: String,
    val column: List<String>,
    val records : List<List<String>>

) {
}