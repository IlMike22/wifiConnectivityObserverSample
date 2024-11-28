package de.mindmarket.wificonnectivityobserversample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ConnectivityViewModel(
    private val connectivityObserver: ConnectivityObserver
): ViewModel() {
    val isConnected = connectivityObserver
        .isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000L),
            false
        )
}