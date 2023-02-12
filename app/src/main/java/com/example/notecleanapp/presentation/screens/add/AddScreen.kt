package com.example.notecleanapp.presentation.screens.add

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notecleanapp.domain.model.Note
import com.example.notecleanapp.presentation.navigation.Screens
import com.example.notecleanapp.presentation.ui.theme.NoteCleanAppTheme
import kotlin.random.Random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavController) {
    val viewModel = hiltViewModel<AddViewModel>()
    var title by rememberSaveable { (mutableStateOf("")) }
    var description by rememberSaveable { (mutableStateOf("")) }

    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = Color(0xFF3B3B3B))
                        .clickable { navController.popBackStack() }

                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = Color(0xFF3B3B3B))
                        .clickable {
                            val color = Color(
                                Random.nextInt(256),
                                Random.nextInt(256),
                                Random.nextInt(256)
                            ).toArgb()
                            viewModel.addNote(
                                Note(
                                    title = title,
                                    content = description,
                                    backgroundColor = color
                                )
                            ) {
                                navController.navigate(Screens.MainScreen.route)
                            }
                        }

                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "add note",
                        tint = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") }
            )
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(text = "Description") },
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddScreen() {
    NoteCleanAppTheme {
        AddScreen(rememberNavController())
    }
}
