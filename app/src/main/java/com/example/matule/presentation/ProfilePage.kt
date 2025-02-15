package com.example.matule.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CardTravel
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FireTruck
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.matule.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun ProfilePage(
    onLogin: () -> Unit,
    navController: NavController,
    inCart: () -> Unit
) {

    var name by rememberSaveable { mutableStateOf("Emmanuel") }
    var lastName by rememberSaveable { mutableStateOf("Oyiboke") }
    var address by rememberSaveable { mutableStateOf("Nigeria") }
    var phone by rememberSaveable { mutableStateOf("+7 811-732-5298") }
    val scrollState = ScrollState(0)
    var customMode by rememberSaveable { mutableStateOf(false) }
    val items =
        listOf("Профиль", "Корзина", "Избранное", "Заказы", "Уведомления", "Настройки", "Выйти")
    val selectedItem = remember { mutableStateOf(items[0]) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    fun getIcon(item: String): ImageVector {
        return when (item) {
            "Профиль" -> Icons.Outlined.AccountCircle
            "Корзина" -> Icons.Outlined.CardTravel
            "Избранное" -> Icons.Outlined.FavoriteBorder
            "Заказы" -> Icons.Outlined.FireTruck
            "Уведомления" -> Icons.Outlined.Notifications
            "Настройки" -> Icons.Outlined.Settings
            "Выйти" -> Icons.Rounded.ExitToApp
            else -> Icons.Rounded.Error
        }
    }


    //Экран профиля
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            if (!customMode) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Icon(
//                        imageVector = Icons.Rounded.Add,
//                        contentDescription = "back",
//                        tint = Color.White
//                    )
//
//                    Text(
//                        text = "Профиль",
//                        fontSize = 16.sp,
//                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
//                        color = Color(0xFF2B2B2B)
//                    )
//
//                    IconButton(
//                        onClick = {
//                            customMode = !customMode
//                        },
//                        modifier = Modifier
//                            .clip(RoundedCornerShape(30.dp))
//                            .background(Color(0xFF48B2E7))
//                            .height(25.dp)
//                            .width(25.dp)
//                    )
//                    {
//                        Icon(
//                            imageVector = Icons.Rounded.Add,
//                            contentDescription = "back",
//                            tint = Color.White
//                        )
//                    }
//                }
//            } else {
//                Button(
//                    onClick = {
//                        customMode = !customMode
//                    },
//                    modifier = Modifier
//                        .width(212.dp),
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF48B2E7)
//                    ),
//                ) {
//                    Text(
//                        text = "Сохранить",
//                        fontSize = 14.sp
//                    )
//                }
//            }

            Spacer(modifier = Modifier.size(60.dp))

            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .height(96.dp)
                    .width(96.dp)
                    .clip(RoundedCornerShape(100.dp))

            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Emmanuel Oyiboke",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.size(10.dp))

            if (customMode) {
                Text(
                    text = "Изменить фото профиля",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                    color = Color(0xFF48B2E7)
                )
            } else {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(67.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(bottom = 10.dp),
                    colors = CardColors(
                        contentColor = Color(0xFFF7F7F9),
                        containerColor = Color(0xFFF7F7F9),
                        disabledContentColor = Color(0xFFF7F7F9),
                        disabledContainerColor = Color(0xFFF7F7F9)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        Text(
                            text = "Открыть",
                            modifier = Modifier
                                .rotate(270f),
                            color = Color(0xFF6A6A6A),
                            fontSize = 12.sp,
                        )

                        Image(
                            bitmap = ImageBitmap.imageResource(id = R.drawable.barcode),
                            contentDescription = "",
                            modifier = Modifier
                                .height(51.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Имя",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F9),
                    unfocusedContainerColor = Color(0xFFF7F7F9),
                    focusedIndicatorColor = Color(0x00F7F7F9),
                    unfocusedIndicatorColor = Color(0x00F7F7F9),
                ),
                placeholder = {
                    Text(
                        text = "Name",
                        color = Color(0xFF6A6A6A),
                    )
                },
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Фамилия",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F9),
                    unfocusedContainerColor = Color(0xFFF7F7F9),
                    focusedIndicatorColor = Color(0x00F7F7F9),
                    unfocusedIndicatorColor = Color(0x00F7F7F9)
                ),
                placeholder = {
                    Text(
                        text = "Last name",
                        color = Color(0xFF6A6A6A),
                    )
                },
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Адрес",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextField(
                value = address,
                onValueChange = { address = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F9),
                    unfocusedContainerColor = Color(0xFFF7F7F9),
                    focusedIndicatorColor = Color(0x00F7F7F9),
                    unfocusedIndicatorColor = Color(0x00F7F7F9)
                ),
                placeholder = {
                    Text(
                        text = "Address",
                        color = Color(0xFF6A6A6A),
                    )
                },
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Телефон",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextField(
                value = phone,
                onValueChange = { phone = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F9),
                    unfocusedContainerColor = Color(0xFFF7F7F9),
                    focusedIndicatorColor = Color(0x00F7F7F9),
                    unfocusedIndicatorColor = Color(0x00F7F7F9)
                ),
                placeholder = {
                    Text(
                        text = "+7 888-888-88-88",
                        color = Color(0xFF6A6A6A),
                    )
                },
            )
        }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color(0xFF48B2E7),
                drawerContentColor = Color.White,
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(id = R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .height(96.dp)
                            .width(96.dp)
                            .clip(RoundedCornerShape(100.dp))
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        text = "Эмануэль Кверти",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        color = Color(0xFFFFFFFF)
                    )

                    Spacer(modifier = Modifier.size(30.dp))

                    items.forEach { item ->
                        Row(
                            modifier = Modifier
                                .clickable {
                                    scope.launch {
                                        getAction(item,
                                            onLogin = {
                                                onLogin()
                                            },
                                            navController,
                                            onClose = {
                                                scope.launch {
                                                    drawerState.close()
                                                }
                                            },
                                            inCart = {
                                                inCart()
                                            }
                                        )
                                    }
                                    selectedItem.value = item
                                }
                        ) {
                            Icon(
                                getIcon(item),
                                contentDescription = "back",
                                tint = Color.White
                            )

                            Spacer(modifier = Modifier.size(10.dp))

                            Text(
                                item,
                                fontSize = 16.sp
                            )
                        }

                        Spacer(modifier = Modifier.size(24.dp))
                    }
                }
            }
        },
        content = {
            if (!customMode) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
                            scope.launch { drawerState.open() }
                        })

                    Text(
                        text = "Профиль",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.new_peninim_mt)),
                        color = Color(0xFF2B2B2B)
                    )

                    IconButton(
                        onClick = {
                            customMode = !customMode
                        },
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color(0xFF48B2E7))
                            .height(25.dp)
                            .width(25.dp)
                    )
                    {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "back",
                            tint = Color.White
                        )
                    }
                }
            } else {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            customMode = !customMode
                        },
                        modifier = Modifier
                            .width(212.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF48B2E7)
                        ),
                    ) {
                        Text(
                            text = "Сохранить",
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    val context = LocalContext.current
    ProfilePage({}, navController = NavController(context = context), {})
}

private fun getAction(
    item: String,
    onLogin: () -> Unit,
    navController: NavController,
    onClose: () -> Unit,
    inCart: () -> Unit
) {
    when (item) {
        "Профиль" -> {
            onClose()
        }

        "Корзина" -> {
            inCart()
        }

        "Избранное" -> {
            navController.navigate(Screens.Favorite.route)
        }

        "Заказы" -> {
            navController.navigate(Screens.Orders.route)
        }

        "Уведомления" -> {
            navController.navigate(Screens.Notification.route)
        }

        "Настройки" -> {}
        "Выйти" -> {
            FirebaseAuth.getInstance().signOut()
            onLogin()
        }
        else -> {

        }
    }
}