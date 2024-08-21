package com.example.jetsnack.ui.home

import android.app.DatePickerDialog
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetsnack.ui.components.JetsnackScaffold
import com.example.jetsnack.ui.theme.JetsnackTheme
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isEditable by remember { mutableStateOf(false) }
    var buttonColor by remember { mutableStateOf(Color.Green) }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val genders = listOf("זכר", "נקבה", "אחר")
    var selectedGender by remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            birthdate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day
    )

    JetsnackScaffold(
        bottomBar = {
            JetsnackBottomBar(
                tabs = HomeSections.values(),
                currentRoute = HomeSections.PROFILE.route,
                navigateToRoute = onNavigateToRoute
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(paddingValues)
        ) {
            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("שם מלא") },
                enabled = isEditable,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = birthdate,
                onValueChange = { birthdate = it },
                label = { Text("תאריך לידה") },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        datePickerDialog.show()
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                TextField(
                    value = selectedGender,
                    onValueChange = { },
                    readOnly = true,
                    label = { Text("מין") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded,
                        )
                    },
                    enabled = isEditable,
                    modifier = Modifier.fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    genders.forEach { gender ->
                        DropdownMenuItem(
                            text = { Text(text = gender) },
                            onClick = {
                                selectedGender = gender
                                expanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("כתובת") },
                enabled = isEditable,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("דואר אלקטרוני") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                enabled = isEditable,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("מספר פלאפון") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                enabled = isEditable,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    isEditable = !isEditable
                    buttonColor = if (isEditable) Color.Black else Color.Red
                    // if (!isEditable){//save user data at the data base}
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(buttonColor),



            ) {
                Text(if (isEditable) "שמור" else "ערוך")

            }
        }
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun ProfilePreview() {
    JetsnackTheme {
        Profile(onNavigateToRoute = { })
    }
}
