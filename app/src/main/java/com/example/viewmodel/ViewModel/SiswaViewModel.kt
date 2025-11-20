package com.example.viewmodel.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {

    private val statusUI = MutableStateFlow(value = Siswa())

    val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

    fun setSiswa(ls:MutableList<String>){
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[2]
            )
        }
    }

}