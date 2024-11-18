package com.app.abc.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.app.abc.presentation.home.HomePage
import com.app.abc.presentation.theme.ABCComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ABCComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomePage()
                }
            }
        }
    }
}