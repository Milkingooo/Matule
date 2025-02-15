package com.example.matule.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CardTravel
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.CardTravel
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R
import com.example.matule.domain.NetworkUtils

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AboutScreen(
                onBack = {
                    finish()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    AboutScreen({})
}

@Composable
fun AboutScreen(
    onBack: () -> Unit
) {
// Экран избранное
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
            ) {
                IconButton(
                    onClick = {
                        onBack()
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFFFFFFF))
                        .height(44.dp)
                        .width(44.dp)
                        .align(Alignment.CenterVertically)
                )
                {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = "back",
                        modifier = Modifier
                            .size(15.dp)
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text = "Sneaker Shop",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF2B2B2B)
                )

                Spacer(modifier = Modifier.size(20.dp))

                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFFFFFFF))
                )
                {
                    Icon(
                        imageVector = Icons.Rounded.CardTravel,
                        contentDescription = "back",
                    )
                }

            }

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = "Nike Air Max 270 \nEssential",
                fontSize = 26.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Men’s Shoes",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF6A6A6A)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "₽179.39",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.size(40.dp))

            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.nike),
                contentDescription = "",
                modifier = Modifier
                    .height(125.dp)
                    .width(420.dp)
            )

            Spacer(modifier = Modifier.size(100.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                items(5){
                    AboutItem()
                }
            }

            Spacer(modifier = Modifier.size(50.dp))

            Text(
                text = "Вставка Max Air 270 обеспечивает непревзойденный комфорт в течение всего дня. Изящный дизайн ........",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF6A6A6A),
                modifier = Modifier
                    .width(335.dp)
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = "Подробнее",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF48B2E7),
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFD9D9D9))
                )
                {
                    Icon(
                        imageVector = Icons.Rounded.FavoriteBorder,
                        contentDescription = "back"
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF48B2E7)
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Outlined.CardTravel,
                            ""
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "В корзину",
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun AboutItem(){
    Card(
        modifier = Modifier
            .width(56.dp)
            .height(56.dp),
        ) {
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.nike),
            contentDescription = "",
            modifier = Modifier
                .height(125.dp)
                .width(420.dp)
        )

    }
}