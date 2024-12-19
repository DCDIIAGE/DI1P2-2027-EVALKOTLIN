package com.example.evaluationkotlin.ui.screens.mainscreen

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.evaluationkotlin.R
import com.example.evaluationkotlin.ui.components.infoboxcomponents.InfoBox
import com.example.evaluationkotlin.ui.components.infoboxcomponents.Title

@Composable
fun MainScreen(
    navController: NavController
) {
    val viewModel: MainViewModel = viewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    val mediaPlayer = MediaPlayer.create(context, R.raw.bomb)

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                is MainScreenEvent.NavigateToDetails -> {
                    navController.navigate("detailsscreen/${event.id}")
                }
                else -> {
                    navController.navigate("mainscreen")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screenbackground))
    ) {
        Title(title = stringResource(id = R.string.maintitle))

        Text(
            text = stringResource(id = R.string.maindescription),
            color = colorResource(id = R.color.descriptioncolor),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        state.weatherList.forEach { weather ->
            InfoBox(
                name = "${weather.day} ${weather.startHour}-${weather.endHour}",
                modifier = Modifier.clickable {
                    viewModel.onWeatherItemClicked(weather.id)
                    vibratePhone(vibrator)
                    playSound(mediaPlayer)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

fun vibratePhone(vibrator: Vibrator) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        @Suppress("DEPRECATION")
        vibrator.vibrate(50)
    }
}

fun playSound(mediaPlayer: MediaPlayer) {
    mediaPlayer.start()
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}
