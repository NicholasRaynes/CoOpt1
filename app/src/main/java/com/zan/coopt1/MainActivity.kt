package com.zan.coopt1

import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.app.DatePickerDialog
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Calendar
import java.util.Date

/**
 * Team: ZAN
 * Members: Nicholas Raynes, Amanda Schepp, Zack Bowles-Lapointe
 * Last Updated: November 12th, 2023
 * Description: A simple application that allows the user to select
 * a date using Android's DatePicker widget and displaying it.
 */

/**
 * MainActivity is the main entry point of the Android application.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Display the date picker UI.
            ShowDatePicker(context = this)
        }
    }
}

/**
 * A composable function that displays a date picker and selected date information.
 *
 * @param context The Android context.
 */
@Composable
fun ShowDatePicker(context: Context) {
    // Initialize date components.
    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    // Create a mutable state for the selected date.
    val date = remember { mutableStateOf("") }

    // OLD IMPLEMENTATION
    //    val datePickerDialog = DatePickerDialog(
    //        context,
    //        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
    //            date.value = "$dayOfMonth/${month+1}/$year"
    //        }, year, month, day
    //    )

    // Composable UI layout using Column.
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the selected date.
        Text(text = "Selected Date: ${date.value}")
        Spacer(modifier = Modifier.size(16.dp))

        // Button to open the date picker dialog.
        Button(onClick = {
            // OLD IMPLEMENTATION
            // datePickerDialog.show()
        }) {
            Text(text = "Open Date Picker")
        }
    }
}