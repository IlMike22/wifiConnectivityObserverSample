package de.mindmarket.wificonnectivityobserversample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import de.mindmarket.wificonnectivityobserversample.ui.theme.WifiConnectivityObserverSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WifiConnectivityObserverSampleTheme {
                val viewModel = viewModel<ConnectivityViewModel> {
                    ConnectivityViewModel(connectivityObserver = AndroidConnectivityObserver(applicationContext))
                }
                val isConnected by viewModel.isConnected.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Box(
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(innerPadding),
                       contentAlignment = Alignment.Center
                   ) {
                       Text(text = "Connected? $isConnected")
                   }
                }
            }
        }
    }
}