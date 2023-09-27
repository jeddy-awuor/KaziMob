package com.example.nafasivibao.ui.theme.screens.rating

import android.widget.RatingBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RatingScreen() {
    var rating by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp, start = 10.dp)
    ) {
        Text(text = "Rate our app:",
            color = Color(68, 69, 74),)
        Spacer(modifier = Modifier.height(8.dp))
        RatingBarWithSnackbar(
            rating = rating,
            onRatingChanged = { newRating ->
                rating = newRating
            }
        )
    }
}
@Preview
@Composable
fun RatingScreenPreview() {

        RatingScreen()
}