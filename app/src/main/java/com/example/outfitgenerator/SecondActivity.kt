package com.example.outfitgenerator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.outfitgenerator.MainViewModel.MainViewModel
import com.example.outfitgenerator.models.Piece
import com.example.outfitgenerator.models.User
import com.example.outfitgenerator.ui.theme.OutfitGeneratorTheme

class SecondActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = intent.getSerializableExtra("user") as? User
        var sessionUsername = user?.username
        setContent {
            OutfitGeneratorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                    if (sessionUsername != null) {
                        WardrobeScreen(viewModel, sessionUsername)
                    }
                }
            }
        }
    }
}

@Composable
fun WardrobeScreen(viewModel: MainViewModel, sessionUsername : String){
    var pieces = viewModel.getPieceList(sessionUsername)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (pieces != null){
        pieces.value!!.forEach { item ->
            PieceRow(item)
        }
        }
    }

}

@Composable
fun PieceRow(item: Piece) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                // Navegar a una nueva pantalla, por ejemplo
                val intent = Intent(context, PieceDetail::class.java)
                intent.putExtra("ITEM_ID", item.id)
            },
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = rememberAsyncImagePainter(model = item.image),
            contentDescription = item.name,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            item.name?.let { Text(text = it) }
            item.brand?.let { Text(text = it, modifier = Modifier.align(Alignment.End)) }
        }
    }
}


@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    OutfitGeneratorTheme {
        Greeting2("Android")
    }
}