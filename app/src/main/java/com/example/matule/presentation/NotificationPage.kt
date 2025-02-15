package com.example.matule.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R

@Composable
fun NotificationPage() {

    //Экран уведомлений
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Menu"
                )

                Spacer(modifier = Modifier.weight(0.1f))

                Text(
                    text = "Уведомления",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF2B2B2B)
                )

                Spacer(modifier = Modifier.weight(0.12f))

            }

            Spacer(modifier = Modifier.size(30.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(10) {
                    NotificationItem()
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationPagePreview() {
    NotificationPage()
}

@Composable
fun NotificationItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .clip(RoundedCornerShape(8.dp))
            .padding(bottom = 10.dp),
        colors = CardColors(
            contentColor = Color(0xFFF7F7F9),
            containerColor = Color(0xFFF7F7F9),
            disabledContentColor = Color(0xFFF7F7F9),
            disabledContainerColor = Color(0xFFF7F7F9)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            Text(
                text = "Заголовок",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF2B2B2B),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF2B2B2B),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "27.01.2024, 15:42",
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF707B81),
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}