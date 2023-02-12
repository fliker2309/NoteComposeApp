package com.example.notecleanapp.presentation.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notecleanapp.presentation.navigation.Screens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    navController: NavController,
    id: String?
) {
    val viewModel = hiltViewModel<DetailsViewModel>()
    val note = viewModel.note.observeAsState().value
    id?.toInt()?.let { viewModel.getNoteById(id = it) }

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
                            viewModel.deleteNote{
                                navController.navigate(Screens.MainScreen.route)
                            }
                        }

                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "delete note",
                        tint = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = note?.title ?: "",
                fontSize = 35.sp,
                style = TextStyle(color = Color(0xFF303030), fontWeight = FontWeight.Light)

            )
            Text(
                text = note?.content ?: "",
                fontSize = 24.sp,
                style = TextStyle(color = Color(0xFF303030), fontWeight = FontWeight.Light)
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewAddScreen() {
    NoteCleanAppTheme {
        DetailsScreen(rememberNavController())
    }
}
*/
