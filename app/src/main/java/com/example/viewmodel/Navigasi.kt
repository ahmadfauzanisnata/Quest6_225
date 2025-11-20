package com.example.viewmodel

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viewmodel.View.FormSiswa
import com.example.viewmodel.View.TampilSiswa
import com.example.viewmodel.ViewModel.SiswaViewModel

private val Long.value: Any

enum class Navigasi {
    Formulir,
    Detail
}

private fun AnimatedContentScope.cancelAndBackToFormulir(navController: NavHostController) {
    TODO("Not yet implemented")
}

@OptIn(markerClass = ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    //edit 1: parameter viewModel
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)