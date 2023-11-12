package com.zan.coopt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Date

// Debug OR Refactor #1 - Nicholas Raynes
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import java.text.SimpleDateFormat
import java.util.TimeZone

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
            ShowDatePicker()
        }
    }
}

/**
 * A composable function that displays a date picker and selected date information.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDatePicker() {
    // Debug OR Refactor #1 - Nicholas Raynes
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            // Allow all dates to be selectable
            return true
        }
    })
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        DatePicker(
            state = datePickerState
        )
        Spacer(
            modifier = Modifier.height(
                32.dp
            )
        )
        Text(
            text = selectedDate.toString(),
        )
    }
}

// Debug OR Refactor #1 - Nicholas Raynes
/**
 * Converts milliseconds to a formatted date string.
 *
 * @param millis The time in milliseconds.
 * @return A formatted date string in the "dd/MM/yyyy" format.
 */
private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return formatter.format(Date(millis))
}