package com.example.matule.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule.R
import com.example.matule.domain.FirebaseRepository
import com.example.matule.domain.NetworkUtils
import com.example.matule.presentation.ui.theme.MatuleTheme

class ForgotActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgotScreen(
                onBack = { finish()  },
                fireRepo = FirebaseRepository(),
                inOtpCheck = {

                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting() {
    ForgotScreen({}, FirebaseRepository(), {})
}


@Composable
fun ForgotScreen(
    onBack: () -> Unit,
    fireRepo: FirebaseRepository,
    inOtpCheck: () -> Unit
) {
    val context = LocalContext.current

    // переменные для сохранения состояния полей и др.
    var email by remember { mutableStateOf("") }
    var isErrorEmail by remember { mutableStateOf(false) }

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

            IconButton(onClick = {
                onBack()
            },
                modifier = Modifier
                    .align(Alignment.Start)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFF7F7F9)))
            {
                Icon(imageVector = Icons.Rounded.ArrowBackIosNew,
                    contentDescription = "back")
            }

            Text(
                text = "Забыл Пароль",
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B),
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Введите Свою Учетную Запись \n Для Сброса",
                fontSize = 16.sp,
                modifier = Modifier
                    .width(300.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF707B81)
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                isError = isErrorEmail,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F9),
                    unfocusedContainerColor = Color(0xFFF7F7F9),
                ),
                placeholder = { Text(text = "xyz@gmail.com", color = Color(0xFF6A6A6A))}
            )

            Spacer(modifier = Modifier.size(40.dp))

            Button(
                onClick = {                                 // валидация данных
                    if (email.isBlank()) isErrorEmail = true
                    isErrorEmail = !isValidEmail(email)
                    if(NetworkUtils.isOnline(context)){
                        Toast.makeText(context, "Нет подключения к сети!", Toast.LENGTH_SHORT).show()
                    }
                    else if (email.isNotBlank() && isValidEmail(email) && NetworkUtils.isOnline(context)) {
                        isErrorEmail = false

                        fireRepo.sendResetLink(email = email){
                            if(it) {
                                Toast.makeText(context,"Ссылка отправлена", Toast.LENGTH_SHORT).show()
                                inOtpCheck()
                            }
                        }
                    }
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
                    text = "Отправить",
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}