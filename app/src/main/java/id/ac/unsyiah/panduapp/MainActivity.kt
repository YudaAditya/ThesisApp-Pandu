package id.ac.unsyiah.panduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ac.unsyiah.panduapp.ui.homescreen.PanduHomeScreen
import id.ac.unsyiah.panduapp.ui.theme.PanduTheme

import org.json.JSONException

import org.json.JSONObject

import org.vosk.LibVosk

import org.vosk.LogLevel

import org.vosk.Model

import org.vosk.Recognizer

import org.vosk.android.RecognitionListener

import org.vosk.android.SpeechService

import org.vosk.android.SpeechStreamService

import org.vosk.android.StorageService

import java.lang.Exception

class MainActivity : ComponentActivity(), RecognitionListener {
private val START_STATE = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContent {
            PanduTheme {
                // A surface container using the 'background' color from the theme
                    Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

    override fun onPartialResult(hypothesis: String?) {
            TODO("Not yet implemented")
    }

    override fun onResult(hypothesis: String?) {
        TODO("Not yet implemented")
    }

    override fun onFinalResult(hypothesis: String?) {
        TODO("Not yet implemented")
    }

    override fun onError(exception: Exception?) {
        TODO("Not yet implemented")
    }

    override fun onTimeout() {
        TODO("Not yet implemented")
    }
}

@Composable
fun PanduLayout(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Yuda Disini")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Yuda Disini")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PanduTheme {
        PanduLayout()
    }
}