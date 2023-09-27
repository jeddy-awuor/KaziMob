package com.example.nafasivibao

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nafasivibao.ui.theme.MooliFont
import com.example.nafasivibao.ui.theme.NafasiVibaoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class SplashActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            SplashActive()

            val Context = LocalContext.current
            val coroutineScope = rememberCoroutineScope()
            coroutineScope.launch {
                delay(2000)
                Context.startActivity(Intent(Context, MainActivity::class.java))
                finish()
            }
        }
    }
}

    @Composable
    fun SplashActive() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(251, 243, 235)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Ready for your next career?",
                fontFamily = MooliFont,
                modifier = Modifier.padding(start = 20.dp),
                fontWeight = FontWeight(300),
                color = Color.Black,
                fontSize = 28.sp,
            )

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottiehand))
            val progress by animateLottieCompositionAsState(composition)
            LottieAnimation(
                composition, progress,
                modifier = Modifier
                    .size(500.dp)
                    .fillMaxWidth()
            )

        }
    }