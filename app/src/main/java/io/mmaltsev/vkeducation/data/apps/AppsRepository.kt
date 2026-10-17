package io.mmaltsev.vkeducation.domain.apps

interface AppsRepository {
    suspend fun getApps(): List<AppSummary>
}