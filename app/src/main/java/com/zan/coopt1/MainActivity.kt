package com.zan.coopt1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowToastButton() {
    val context = LocalContext.current

    var showToast by remember { mutableStateOf(false) }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    if (showToast) {
        val message = "Hello, $firstName $lastName"
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        showToast = false
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = firstName,
            onValueChange = { newValue -> firstName = newValue },
            label = { Text(text = "Enter your first name") },
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { newValue -> lastName = newValue },
            label = { Text(text = "Enter your last name") },
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { showToast = true },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Done")
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowToastButton()
        }
    }
}