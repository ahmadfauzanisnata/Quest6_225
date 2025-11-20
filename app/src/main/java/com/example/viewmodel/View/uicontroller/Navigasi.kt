package com.example.viewmodel.View.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.platform.LocalContext
import com.example.viewmodel.model.DataJK.jenisK

import com.example.viewmodel.View.FormSiswa
import com.example.viewmodel.View.TampilSiswa
import com.example.viewmodel.ViewModel.SiswaViewModel


enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    navController: NavHostController,
    viewModel: SiswaViewModel
) {

    val uiState = viewModel.statusUI.collectAsState()

    Scaffold { isiRuang ->

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {


            composable(route = Navigasi.Formulir.name) {

                val konteks = LocalContext.current

                FormSiswa(
                    pilihanJK = jenisK.map { id ->
                        konteks.resources.getString(id)
                    },
                    onSubmitButtonClicked = { siswa ->
                        viewModel.setSiswa(siswa)
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }


            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = {
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(
        route = Navigasi.Formulir.name,
        inclusive = false
    )
}
