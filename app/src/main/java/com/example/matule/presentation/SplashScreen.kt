package com.example.matule.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    onEnd: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF44A9DC),
                        Color(0xFF2B6B8B)
                    )
                ),
            )
    ) {
        // количество слайдов
        val pagerState = rememberPagerState(pageCount = {
            3
        })

        // элемент для прокрутки слайдов
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { page ->

            when (page) {
                0 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "ДОБРО \n ПОЖАЛОВАТЬ",
                            fontSize = 30.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.image_splash1),
                            contentDescription = "",
                            modifier = Modifier
                                .height(420.dp)
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.weight(1f))
                    }
                }

                1 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.image_2),
                            contentDescription = "",
                            modifier = Modifier
                                .height(420.dp)
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "Начнем \n путешествие",
                            fontSize = 34.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )

                        Spacer(modifier = Modifier.size(16.dp))

                        Text(
                            text = "Умная, великолепная и модная \n коллекция Изучите сейчас",
                            fontSize = 16.sp,
                            color = Color(0xFFD8D8D8),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )

                        Spacer(modifier = Modifier.weight(1f))
                    }
                }

                2 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.image_3),
                            contentDescription = "",
                            modifier = Modifier
                                .height(420.dp)
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "У вас есть сила, \n чтобы",
                            fontSize = 34.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )

                        Spacer(modifier = Modifier.size(16.dp))

                        Text(
                            text = "В вашей комнате много красивых и \n привлекательных растений",
                            fontSize = 16.sp,
                            color = Color(0xFFD8D8D8),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(Font(R.font.new_peninim_mt))
                        )

                        Spacer(modifier = Modifier.weight(1f))
                    }
                }

                3 -> {
                    onEnd()
                }
            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color(0xFFFFFFFF) else Color(0xFF2B6B8B)
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(color)
                        .size(16.dp)
                )
            }
        }

        Button(
            onClick = {
                if(pagerState.currentPage == 2) {
                    onEnd()
                }
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF)
            ),
        ) {
            when (pagerState.currentPage) {
                0 -> {
                    Text(
                        text = "Начать",
                        fontSize = 14.sp,
                        color = Color(0xFF2B2B2B)
                    )
                }

                else -> {
                    Text(
                        text = "Далее",
                        fontSize = 14.sp,
                        color = Color(0xFF2B2B2B)
                    )
                }
            }

        }
        Spacer(modifier = Modifier.size(10.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashScreen({})
}