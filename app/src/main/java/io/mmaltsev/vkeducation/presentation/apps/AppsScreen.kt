package io.mmaltsev.vkeducation.presentation.apps

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.domain.apps.AppSummary

@Composable
fun AppsScreen(
    viewModel: AppsViewModel = hiltViewModel(),
) {
    val apps by viewModel.apps.collectAsState()

    Column(Modifier.fillMaxSize()) {
        AppListToolbar(
            currentAppIconRes = R.mipmap.ic_launcher,
            title = "Приложения",
        )
        LazyColumn(Modifier.fillMaxSize()) {
            items(apps, key = { it.id }) { app ->
                AppListItem(app)
                HorizontalDivider()
            }
        }
    }
}

@Composable
private fun AppListToolbar(
    @DrawableRes currentAppIconRes: Int,
    title: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(currentAppIconRes),
            contentDescription = "Текущее приложение",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(32.dp),
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Composable
private fun AppListItem(app: AppSummary) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = app.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(56.dp),
        )
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = app.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = app.shortDescription,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = app.category.name,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}