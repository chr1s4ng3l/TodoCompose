package com.tamayo.todocompose

import android.content.ClipData.Item
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamayo.todocompose.ui.theme.TodoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoCompose()
                }
            }
        }
    }
}


@Composable
fun TodoCompose() {

    var txt by remember { mutableStateOf("") }
    val todo: MutableList<String> = remember { mutableListOf() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(value = txt, onValueChange = { txt = it })

        OutlinedButton(onClick = {

            todo.add(txt)
            txt = ""

        }) {

            Text(text = "Click here")


        }

        LazyColumn(content = {
            itemsIndexed(todo) { index, item ->
                Log.d("AL", item)
                Text(text = item)

            }

        }, reverseLayout = true

        )

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoComposeTheme {

        TodoCompose()

    }
}