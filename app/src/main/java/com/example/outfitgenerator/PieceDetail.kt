package com.example.outfitgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.outfitgenerator.MainViewModel.MainViewModel
import com.example.outfitgenerator.ui.theme.OutfitGeneratorTheme

class PieceDetail : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val sessionUserId = intent.getStringExtra("SESSION_USER_ID")
        setContent {
            OutfitGeneratorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                    WardrobeScreen(viewModel, sessionUserId)
                }
            }
        }
    }
}