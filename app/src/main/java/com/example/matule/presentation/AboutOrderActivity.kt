package com.example.matule.presentation

import android.os.Bundle
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
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.rounded.ArrowBackIosNew
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R

class AboutOrderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AboutOrderScreen(
                onBack = {
                    finish()
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    AboutOrderScreen({})
}

@Composable
fun AboutOrderScreen(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
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

                Spacer(modifier = Modifier.weight(0.7f))

                Text(
                    text = "325556516",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF2B2B2B)
                )

                Spacer(modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = "7 минут назад",
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.End),
                color = Color(0xFF6A6A6A),

                )

            Spacer(modifier = Modifier.size(16.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                items(2) {
                    OrdersItem(
                        "",
                        inAbout = {

                        }
                    )
                }
            }

            Spacer(modifier = Modifier.size(16.dp))

            Card {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFFFFF))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Контактная информация",
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        fontSize = 14.sp,
                        color = Color(0xFF2B2B2B)
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF7F7F9))) {
                            Icon(
                                Icons.Outlined.Email,
                                ""
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .width(152.dp)
                        ) {
                            Text(
                                text = "emmanuel@gmail.com",
                                color = Color(0xFF2B2B2B),
                                fontSize = 14.sp
                            )

                            Spacer(modifier = Modifier.size(5.dp))

                            Text(
                                text = "Email",
                                modifier = Modifier.fillMaxWidth(),
                                color = Color(0xFF6A6A6A),
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF7F7F9))) {
                            Icon(
                                Icons.Outlined.Phone,
                                ""
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .width(152.dp)
                        ) {
                            Text(
                                text = "+234-811-732-5298",
                                color = Color(0xFF2B2B2B),
                                fontSize = 14.sp
                            )

                            Spacer(modifier = Modifier.size(5.dp))

                            Text(
                                text = "Телефон",
                                modifier = Modifier.fillMaxWidth(),
                                color = Color(0xFF6A6A6A),
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Адрес",
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        fontSize = 14.sp,
                        color = Color(0xFF2B2B2B)
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "1082 Аэропорт, Нигерии",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFF6A6A6A),
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Способ оплаты",
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        fontSize = 14.sp,
                        color = Color(0xFF2B2B2B)
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF7F7F9))) {
                            Image(
                                bitmap = ImageBitmap.imageResource(id = R.drawable.card_credit),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(420.dp)
                                    .fillMaxWidth()
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .width(152.dp)
                        ) {
                            Text(
                                text = "DbL Card",
                                color = Color(0xFF2B2B2B),
                                fontSize = 14.sp
                            )

                            Spacer(modifier = Modifier.size(5.dp))

                            Text(
                                text = "**** **** 0696 4629",
                                modifier = Modifier.fillMaxWidth(),
                                color = Color(0xFF6A6A6A),
                                fontSize = 12.sp
                            )
                        }
                    }



                }
            }

        }
    }
}
