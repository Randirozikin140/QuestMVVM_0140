
package com.example.pam8.View.uiControler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.pam8.View.FormSiswa
import com.example.pam8.View.TampilSiswa
import com.example.pam8.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun SiswaApp(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier
    ) { isiRuang ->

        // Mengambil data dari ViewModel
        val uiState = viewModel.statusUI.collectAsState()

        // Navigasi halaman
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {

            // HALAMAN FORMULIR
            composable(route = Navigasi.Formulir.name) {

                val konteks = LocalContext.current

                FormSiswa(
                    pilihanJK = listOf(
                        "Laki-laki",
                        "Perempuan"
                    ),

                    onSubmitButtonClicked = { data ->

                        viewModel.setSiswa(data)

                        navController.navigate(
                            Navigasi.Detail.name
                        )
                    }
                )
            }

            // HALAMAN DETAIL
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

// Fungsi kembali ke formulir
private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(
        Navigasi.Formulir.name,
        inclusive = false
    )
}
