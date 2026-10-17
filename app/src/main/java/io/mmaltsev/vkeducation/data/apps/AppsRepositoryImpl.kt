package io.mmaltsev.vkeducation.data.apps

import io.mmaltsev.vkeducation.domain.appdetails.Category
import io.mmaltsev.vkeducation.domain.apps.AppSummary
import io.mmaltsev.vkeducation.domain.apps.AppsRepository
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor() : AppsRepository {

    override suspend fun getApps(): List<AppSummary> = SAMPLE_APPS

    private companion object {
        val SAMPLE_APPS = listOf(
            AppSummary(
                id = "1",
                name = "Кошелёк+",
                shortDescription = "Учёт расходов и бюджета",
                category = Category.FINANCE, // Оставляем, если есть
                iconUrl = "https://picsum.photos/seed/wallet/128",
            ),
            AppSummary(
                id = "2",
                name = "Файловый менеджер",
                shortDescription = "Быстрый доступ к файлам",
                category = Category.ENTERTAINMENT, // Замените TOOLS на реальное значение
                iconUrl = "https://picsum.photos/seed/files/128",
            ),
            AppSummary(
                id = "3",
                name = "Sky Runner",
                shortDescription = "Аркада с прыжками",
                category = Category.ENTERTAINMENT, // Замените GAMES
                iconUrl = "https://picsum.photos/seed/sky/128",
            ),
            AppSummary(
                id = "4",
                name = "ГосПортал",
                shortDescription = "Госуслуги в одном месте",
                category = Category.SOCIAL, // Замените GOVERNMENT
                iconUrl = "https://picsum.photos/seed/gov/128",
            ),
            AppSummary(
                id = "5",
                name = "Город.Транспорт",
                shortDescription = "Расписание и билеты",
                category = Category.SOCIAL, // Замените TRANSPORT
                iconUrl = "https://picsum.photos/seed/transport/128",
            ),
        )
    }
}