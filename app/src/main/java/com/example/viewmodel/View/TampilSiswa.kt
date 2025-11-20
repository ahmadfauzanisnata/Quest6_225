package com.example.viewmodel.View


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


import androidx.compose.ui.res.dimensionResource
import androidx.compose.foundation.layout.Arrangement

import com.example.viewmodel.R
import com.example.viewmodel.model.Siswa


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {

    val items = listOf(
        Pair(first = stringResource(id = R.string.nama), second = statusUiSiswa.nama),
        Pair(first = stringResource(id = R.string.gender), second = statusUiSiswa.gender),
        Pair(first = stringResource(id = R.string.alamat), second = statusUiSiswa.alamat)
    )

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.detail), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { isiRuang ->

        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.padding(
                    all = dimensionResource(id = R.dimen.padding_medium)
                ),
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensionResource(id = R.dimen.padding_small)
                )
            ) {

                items.forEach { item ->
                    Column {
                        Text(
                            text = item.first.uppercase(),
                            fontSize = 16.sp
                        )
                        Text(
                            text = item.second,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Divider(
                            thickness = dimensionResource(id = R.dimen.thickness_divider)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(
                        dimensionResource(id = R.dimen.padding_small)
                    )
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackButtonClicked
                ) {
                    Text(text = stringResource(id = R.string.back))
                }
            }
        }
    }
}


