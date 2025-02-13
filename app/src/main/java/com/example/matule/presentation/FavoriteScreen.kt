package com.example.matule.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoritePage(){

    // Экран понравившихся
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "Favorite",
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePagePreview(){
    FavoritePage()
}