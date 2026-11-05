package com.example.pam8.View

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pam8.R
import com.example.pam8.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    // edit 1 : parameter statusUiSiswa
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {
    // edit 2 : items Pair
    val items = listOf(
        Pair(stringResource(R.string.nama), statusUiSiswa.nama),
        Pair(stringResource(R.string.gender), statusUiSiswa.gender),
        Pair(stringResource(R.string.alamat), statusUiSiswa.alamat)
    )

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.detail),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(R.color.purple_500)
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
                    dimensionResource(R.dimen.padding_medium)
                ),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.padding_small)
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
                    }

                    Divider(
                        thickness = dimensionResource(
                            R.dimen.thickness_divider
                        )
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    dimensionResource(R.dimen.padding_small)
                )
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackButtonClicked
            ) {
                Text(
                    text = stringResource(R.string.back)
                )
            }
        }
    }
}
