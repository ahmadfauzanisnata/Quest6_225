package com.example.viewmodel.View

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewmodel.R

private val Siswa.alamat: Any
private val Siswa.nama: Any
private val Siswa.gender: Any

@OptIn(markerClass = ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    //edit 1: parameter statusUISiswa
    statusUISiswa: Siswa,
    onBackButtonClicked: () -> Unit,
) {
    //edit 2: items Pair
    val items = listOf(
        Pair(first = stringResource("Nama Lengkap"), second = statusUISiswa.nama),
        Pair(first = stringResource(id = "Jenis Kelamin"), second = statusUISiswa.gender),
        Pair(first = stringResource(id = "Alamat"), second = statusUISiswa.alamat),
    )

    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = "Data Siswa"), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.purple_500)),
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(all = dimensionResource(16.dp)),
                verticalArrangement = Arrangement.spacedBy(space = dimensionResource(10.dp))
            ) {
                items.forEach { item ->
                    Column(
                        Text(text = item.first.uppercase(), fontSize = 16.sp)
                                Text(text = item.second, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Divider(thickness = dimensionResource(1.dp))
            }
        }

