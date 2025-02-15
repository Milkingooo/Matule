package com.example.matule.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
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

class LoginActivity : ComponentActivity() {

    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(
                inHome = {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                },
                inReg = {
                    startActivity(Intent(this, SignUpActivity ::class.java))
                    finish()
                },
                inForgot = {
                    startActivity(Intent(this, ForgotActivity ::class.java))
                },
                loginVm = FirebaseRepository(),
                context = this

            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LoginScreen({}, {}, {}, loginVm = FirebaseRepository(), context = LocalContext.current)
}

@Composable
fun LoginScreen(
    inHome: () -> Unit,
    inReg: () -> Unit,
    inForgot: () -> Unit,
    loginVm: FirebaseRepository,
    context: Context
) {
    // переменные для сохранения состояния полей и др.
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isErrorEmail by remember { mutableStateOf(false) }
    var isErrorPassword by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Привет!",
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B),
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Заполните Свои Данные Или Продолжите Через Социальные Сети",
                fontSize = 16.sp,
                modifier = Modifier
                    .width(300.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF707B81)
            )

            Spacer(modifier = Modifier.size(60.dp))
            Text(
                text = "Email",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                isError = isErrorEmail,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F9),
                    unfocusedContainerColor = Color(0xFFF7F7F9),
                    focusedIndicatorColor = Color(0x00F7F7F9),
                    unfocusedIndicatorColor = Color(0x00F7F7F9)
                ),
                placeholder = { Text(text = "xyz@gmil.com",
                    color = Color(0xFF6A6A6A),)}
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "Пароль",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    isError = isErrorPassword,
                    singleLine = true,
                    visualTransformation = if (showPassword) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF7F7F9),
                        unfocusedContainerColor = Color(0xFFF7F7F9),
                        focusedIndicatorColor = Color(0x00F7F7F9),
                        unfocusedIndicatorColor = Color(0x00F7F7F9)
                    ),
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        fontSize = 14.sp
                    )


                )

                if (showPassword) {
                    Icon(
                        Icons.Filled.VisibilityOff,
                        contentDescription = "Password",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(16.dp)
                            .clickable {
                                showPassword = !showPassword
                            }

                    )
                } else {
                    Icon(
                        Icons.Filled.Visibility,
                        contentDescription = "Password",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(16.dp)
                            .clickable {
                                showPassword = !showPassword
                            }

                    )
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Восстановить",
                fontSize = 12.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        inForgot()
                    },
                color = Color(0xFF707B81),
                fontFamily = FontFamily(Font(R.font.new_peninim_mt))
            )

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                onClick = {                                 // валидация данных
                    if (email.isBlank()) isErrorEmail = true
                    if (password.isBlank()) isErrorPassword = true
                    isErrorEmail = !isValidEmail(email)
                    if(!NetworkUtils.isOnline(context)){
                        Toast.makeText(context, "Нет подключения к сети!", Toast.LENGTH_SHORT).show()
                    }
                    if (password.length <= 6){
                        Toast.makeText(context, "Пароль должен быть > 6 символов!", Toast.LENGTH_SHORT).show()
                    }
                    else if (email.isNotBlank() && password.isNotBlank() && isValidEmail(email)) {
                        isErrorPassword = false
                        isErrorEmail = false
                        loginVm.signIn(email, password){
                            if (it) {
                                Toast.makeText(context, "Успешный вход", Toast.LENGTH_SHORT).show()
                                inHome()
                            }
                            else {
                                Toast.makeText(context, "Ошибка авторизации", Toast.LENGTH_SHORT).show()
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
                    text = "Войти",
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    inReg()
                }
        ) {
            Text(
                text = "Вы впервые?",
                fontSize = 16.sp,
                color = Color(0xFF6A6A6A),
                fontFamily = FontFamily(Font(R.font.new_peninim_mt))
            )
            Text(
                text = " Создать пользователя",
                fontSize = 16.sp,
                color = Color(0xFF6A6A6A),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt))
            )
        }

    }
}

// проверка почты на корректность
fun isValidEmail(email: String): Boolean {
    val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    return email.matches(emailRegex)
}