package id.ac.unsyiah.panduapp.ui.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ac.unsyiah.panduapp.R

@Composable
fun MapScreen() {
    val painter = painterResource(id = R.drawable.red_sun) // Replace with the actual resource ID or asset path
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painter,
            contentDescription = null, // Provide a meaningful description if needed
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f) // Adjust the aspect ratio as needed
                .padding(16.dp)
        )
    }

}

@Composable
@Preview
fun MapScreenPreview() {
    MapScreen()
}