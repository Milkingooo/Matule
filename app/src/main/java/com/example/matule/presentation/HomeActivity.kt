package com.example.matule.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {

                        },
                        containerColor = Color(0xFF48B2E7),
                        shape = RoundedCornerShape(30.dp),
                        modifier = Modifier
                            .height(56.dp)
                            .width(56.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                },
                content = { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        HomeScreen(navController = navController,
                            inAbout = {
                                startActivity(Intent(this@HomeActivity, AboutActivity::class.java))
                            })
                    }
                },
            )
        }
    }
}

