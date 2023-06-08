package id.ac.unsyiah.panduapp.ui.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import id.ac.unsyiah.panduapp.ui.map.MapScreen
import org.vosk.Model
import org.vosk.android.SpeechService
import org.vosk.android.SpeechStreamService

@Composable
fun PanduHomeScreen() {
    Column() {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ){
            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                MapScreen()
            }

        }

        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Text(
                    text = "Pandu Navigasi",
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }

        }
    }


}




// Vosk Initialize

private fun initializeVoskRecognizer(){
    val model: Model
    val speechService: SpeechService
    val speechStreamService: SpeechStreamService



}


@Composable
@Preview
fun PanduHomeScreenPreview() {
    val navController = rememberNavController()
    PanduHomeScreen()
}