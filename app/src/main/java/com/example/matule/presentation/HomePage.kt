package com.example.matule.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CardTravel
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R

@Composable
fun HomePage(
    onAbout2: () -> Unit
) {

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
                        focusedIndicatorColor = Color(0x00F7F7F9),
                        unfocusedIndicatorColor = Color(0x00F7F7F9)
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

            Spacer(modifier = Modifier.size(10.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                items(5){
                    Button(onClick = {},
                        modifier = Modifier
                            .width(108.dp)
                            .height(40.dp),
                        colors = ButtonColors(
                            containerColor = Color(0xFFFFFFFF),
                            contentColor = Color.Black,
                            disabledContentColor = Color(0xFFFFFFFF),
                            disabledContainerColor = Color.Black
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ){
                        Text(
                            text = "Все",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )
                    }

                    Spacer(modifier = Modifier.size(5.dp))
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Популярное",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                columns = GridCells.Fixed(2)
            ) {
                items(10){
                    MenuItem(){
                        onAbout2()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage({})
}

// Элемент меню

@Composable
fun MenuItem(onAbout: () -> Unit){
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(182.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(10.dp)
            .clickable {
                onAbout()
            },
        colors = CardColors(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color(0xFFFFFFFF),
            disabledContentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF)
        )
    ){
        var favorite by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Box {
                if(favorite) {
                    IconButton(
                        onClick = {
                            favorite = !favorite
                        },
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
                            imageVector = Icons.Outlined.Favorite,
                            contentDescription = "Favorite",
                            tint = Color(0xFFF87265)
                        )
                    }
                }
                else{
                    IconButton(
                        onClick = {
                            favorite = !favorite
                        },
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
                        )
                    }
                }

                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.image_2),
                    contentDescription = "",
                    modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = "BEST SELLER",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF48B2E7),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = "Nike Air Max",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF6A6A6A),
                fontSize = 16.sp
            )


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "₽752.00",
                    color = Color(0xFF2B2B2B),
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic
                )

                IconButton(onClick = {
                },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF48B2E7))
                        .height(34.dp)
                        .width(34.dp))
                {
                    Icon(imageVector = Icons.Rounded.Add,
                        contentDescription = "back",
                        tint = Color(0xFFFFFFFF)
                    )
                }
            }
        }

    }
}