package com.example.matule.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CardTravel
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R

@Composable
fun HomePage() {

    var searchQuery by remember { mutableStateOf("") }

    // Главный экран
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(imageVector = Icons.Outlined.Menu,
                    contentDescription = "Menu")

                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text = "Главная",
                    fontSize = 32.sp,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF2B2B2B)
                )

                Spacer(modifier = Modifier.size(20.dp))

                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Outlined.CardTravel,
                        contentDescription = "Menu")
                    
                }

            }

            Spacer(modifier = Modifier.size(20.dp))

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {

                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .height(52.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .weight(1f),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFFFFFFF),
                        unfocusedContainerColor = Color(0xFFFFFFFF),
                    ),
                    leadingIcon = {
                        Icon(imageVector = Icons.Outlined.Search,
                            contentDescription = "Search",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp))
                    },
                    placeholder = {
                        Text(text = "Поиск",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                            color = Color(0xFF6A6A6A)
                        )
                    }
                )

                Spacer(modifier = Modifier.weight(0.1f))

                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .width(52.dp)
                        .height(52.dp),
                    colors = IconButtonColors(
                        containerColor = Color(0xFF48B2E7),
                        contentColor = Color.White,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color(0xFF48B2E7)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Menu Settings",
                        modifier = Modifier.weight(0.1f)
                    )
                }

            }

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = "Категории",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Text(
                text = "Популярное",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(10){
                    MenuItem()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage()
}

// Элемент меню

@Composable
fun MenuItem(){
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(182.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = CardColors(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color(0xFFFFFFFF),
            disabledContentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF)
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .width(28.dp)
                    .height(28.dp),
                colors = IconButtonColors(
                    containerColor = Color(0xFFF7F7F9),
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color(0xFFF7F7F9)
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier.weight(0.1f)
                )
            }

            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.image_2),
                contentDescription = "",
                modifier = Modifier
                    .height(70.dp)
                    .weight(117.91f)
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = "BEST SELLER",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF48B2E7),
                fontSize = 12.sp
            )
            Text(
                text = "Nike Air Max",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF6A6A6A),
                fontSize = 16.sp
            )
        }

    }
}