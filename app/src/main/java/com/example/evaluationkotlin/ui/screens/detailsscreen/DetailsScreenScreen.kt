package com.example.evaluationkotlin.ui.screens.detailsscreen

import DetailsScreenViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.evaluationkotlin.R
import com.example.evaluationkotlin.ui.components.infoboxcomponents.Title

@Composable
fun DetailsScreen(id: Int, navController: NavController) {
    val viewModel: DetailsScreenViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(id) {
        viewModel.loadWeather(id)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screenbackground))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Title(stringResource(id = R.string.detailstitle))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            state.weather?.let { w ->
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.detailsdescription), color = colorResource(id = R.color.infoboxtextcolor))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = stringResource(id = R.string.detailsdescriptiondate)+": ${w.day}", color = colorResource(id = R.color.infoboxtextcolor))
                    Text(text = stringResource(id = R.string.detailsdescriptionstart)+": ${w.startHour}", color = colorResource(id = R.color.infoboxtextcolor))
                    Text(text = stringResource(id = R.string.detailsdescriptionend)+": ${w.endHour}", color = colorResource(id = R.color.infoboxtextcolor))
                    Text(text = stringResource(id = R.string.detailsdescriptionweathertype)+": ${w.weatherType}", color = colorResource(id = R.color.infoboxtextcolor))
                }
            }
        }

        Button(
            onClick = { navController.navigate("mainscreen") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(id = R.string.backbutton))
        }
    }
}
