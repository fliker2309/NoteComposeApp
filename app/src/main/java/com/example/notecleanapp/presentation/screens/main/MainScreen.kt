package com.example.notecleanapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notecleanapp.presentation.navigation.Screens
import com.example.notecleanapp.presentation.screens.main.MainViewModel
import com.example.notecleanapp.presentation.ui.components.NoteItem
import com.example.notecleanapp.presentation.ui.theme.NoteCleanAppTheme
import com.example.notecleanapp.presentation.ui.theme.backgroundColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    val viewModel: MainViewModel = hiltViewModel()
    val notes = viewModel.notes.observeAsState(listOf()).value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screens.AddScreen.route) }) {
                Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "add")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Notes",
                fontSize = 42.sp,
                color = Color(0xFF252525),
                modifier = Modifier
                    .padding(top = 42.dp, start = 24.dp, bottom = 12.dp)


            )

            notes.forEach { note ->
                NoteItem(
                    title = note.title,
                    backgroundColor = Color(note.backgroundColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(vertical = 12.dp)
                        .clickable { navController.navigate(Screens.DetailsScreen.route + "/${note.id}") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewMainScreen() {
    NoteCleanAppTheme {
        MainScreen(rememberNavController())
    }
}
