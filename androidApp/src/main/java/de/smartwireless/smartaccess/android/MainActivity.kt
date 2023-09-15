package de.smartwireless.smartaccess.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.smartwireless.smartaccess.feature.AndroidFeatureViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView()
                }
            }
        }
    }
}

@Composable
fun GreetingView(
    modifier: Modifier = Modifier,
    id: Int = 10,
    vm: AndroidFeatureViewModel = koinViewModel(parameters = { parametersOf(id) }),
) {
    val state = vm.collectAsState()
    Box(modifier.fillMaxSize()) {
        GreetingContent(
            modifier = Modifier.align(Alignment.Center),
            counter = state.value.counter,
            onClick = vm::onClick
        )
    }
}

@Composable
fun GreetingContent(
    modifier: Modifier = Modifier,
    counter: Int,
    onClick: () -> Unit = {}
) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = "counter: $counter")
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    MyApplicationTheme {
        GreetingContent(
            counter = 5
        )
    }
}
