package com.example.composeuitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.example.composeuitest.ui.theme.ComposeUITestTheme

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(mainViewModel: MainViewModel) {
    val observeText = mainViewModel.text.observeAsState()
    Column {
        Button(modifier = Modifier.testTag("ChangeButton"), onClick = {
            mainViewModel.text.value = "Android clicked"
        }) {
            Text(text = "Button")
        }
        Text(modifier = Modifier.testTag("textTest"),text = observeText.value ?: "android")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}