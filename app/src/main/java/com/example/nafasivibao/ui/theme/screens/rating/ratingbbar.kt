package com.example.nafasivibao.ui.theme.screens.rating

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RatingBarWithSnackbar(
    maxRating: Int = 5,
    rating: Int,
    onRatingChanged: (Int) -> Unit,
    starIcon: ImageVector = Icons.Default.Star,
    emptyStarColor: Color = Color.Gray,
    filledStarColor: Color = Color.Yellow
) {
    var currentRating by remember { mutableStateOf(rating) }
    var snackbarVisible by remember { mutableStateOf(false) }

    Row {
        for (i in 1..maxRating) {
            val isFilled = i <= currentRating
            Icon(
                imageVector = starIcon,
                contentDescription = null,
                tint = if (isFilled) filledStarColor else emptyStarColor,
                modifier = Modifier
                    .width(48.dp)
                    .clickable {
                        currentRating = i
                        onRatingChanged(i)
                        snackbarVisible = true
                    }
            )
        }
    }

    if (snackbarVisible) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                TextButton(
                    onClick = { snackbarVisible = false
                        currentRating = -1}
                ) {
                    Text(text = "Dismiss"
                    )
                }
            }
        ) {
            Text(text = "Thank you for rating us!")
        }
    }
}


