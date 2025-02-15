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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R
import com.example.matule.domain.NetworkUtils

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartScreen(
                onBack = {
                    finish()
                }
            )
        }
    }
}

@Composable
fun CartScreen(
    onBack: () -> Unit
) {
    val count by remember { mutableStateOf(0) }

// Экран корзины
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(258.dp),
                containerColor = Color(0xFFFFFFFF)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .padding(top = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Сумма",
                            fontSize = 16.sp,
                            color =Color(0xFF707B81),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )
                        Text(
                            text = "₽753.95",
                            fontSize = 16.sp,
                            color =Color(0xFF2B2B2B),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Доставка",
                            fontSize = 16.sp,
                            color =Color(0xFF707B81),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))

                        )
                        Text(
                            text = "₽60.20",
                            fontSize = 16.sp,
                            color =Color(0xFF2B2B2B),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))

                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Итого",
                            fontSize = 16.sp,
                            color =Color(0xFF2B2B2B),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))

                        )
                        Text(
                            text = "₽60.20",
                            fontSize = 16.sp,
                            color =Color(0xFF48B2E7),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))

                        )
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF48B2E7)
                        ),
                    ) {
                        Text(
                            text = "Оформить Заказ",
                            fontSize = 14.sp
                        )
                    }


                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F9))
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { onBack() },
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

                    Spacer(modifier = Modifier.weight(0.7f))

                    Text(
                        text = "Корзина",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        color = Color(0xFF2B2B2B)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                }

                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text = "$count товара",
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                )

                Spacer(modifier = Modifier.size(16.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    items(10) {
                        CartItem()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    CartScreen({})
}

@Composable
fun CartItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
            .clip(RoundedCornerShape(8.dp))
            .padding(bottom = 10.dp),
        colors = CardColors(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color(0xFFFFFFFF),
            disabledContentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.image_2),
                contentDescription = "",
                modifier = Modifier
                    .height(85.dp)
                    .width(87.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF7F7F9))
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Nike Air Max",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF6A6A6A),
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = "₽752.00",
                    color = Color(0xFF2B2B2B),
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}