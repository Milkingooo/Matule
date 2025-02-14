package com.example.matule.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R

class OtpCheckActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtpCheckScreen(
                onBack = { finish() }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    OtpCheckScreen({})
}

@Composable
fun OtpCheckScreen(
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(0.1f))

            IconButton(
                onClick = {
                    onBack()
                },
                modifier = Modifier
                    .align(Alignment.Start)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFF7F7F9))
            )
            {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIosNew,
                    contentDescription = "back"
                )
            }

            Text(
                text = "OTP Проверка",
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B),
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Пожалуйста, проверьте свою электронную почту, чтобы увидеть код подтверждения",
                fontSize = 16.sp,
                modifier = Modifier
                    .width(300.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF707B81)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "ОТР Код",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(6) {
                    OtpItem()
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Отправить заново",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF707B81)
                )
                Text(
                    text = "00:30",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF707B81)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun OtpItem() {
    var valu by remember { mutableStateOf("0") }

    Card(
        modifier = Modifier
            .width(49.dp)
            .height(99.dp),
        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = valu,
                onValueChange = {
                    valu = it
                },
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    color = Color(0xFF2B2B2B),
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0x00F7F7F9),
                    unfocusedContainerColor = Color(0x00F7F7F9),
                    focusedIndicatorColor = Color(0x00F7F7F9),
                    unfocusedIndicatorColor = Color(0x00F7F7F9)
                ),
                singleLine = true
            )
        }
    }
}
