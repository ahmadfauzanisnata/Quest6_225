package com.example.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.viewmodel.View.uicontroller.SiswaApp
import com.example.viewmodel.ui.theme.ViewModelTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Cukup panggil SiswaApp, navigasi dan ViewModel akan diurus di dalamnya
                    SiswaApp(
                        navController = rememberNavController(),
                        viewModel = viewModel() // Corrected: Call the viewModel() function
                    )
                }
            }
        }
    }
}
