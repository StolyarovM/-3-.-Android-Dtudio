package io.mmaltsev.vkeducation.presentation.apps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.mmaltsev.vkeducation.domain.apps.AppSummary
import io.mmaltsev.vkeducation.domain.apps.AppsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppsViewModel @Inject constructor(
    private val repository: AppsRepository,
) : ViewModel() {

    private val _apps = MutableStateFlow<List<AppSummary>>(emptyList())
    val apps: StateFlow<List<AppSummary>> = _apps.asStateFlow()

    init {
        viewModelScope.launch {
            _apps.value = repository.getApps()
        }
    }
}