package io.mmaltsev.vkeducation.domain.apps

import io.mmaltsev.vkeducation.domain.appdetails.Category

data class AppSummary(
    val id: String,
    val name: String,
    val shortDescription: String,
    val category: Category,
    val iconUrl: String,
)