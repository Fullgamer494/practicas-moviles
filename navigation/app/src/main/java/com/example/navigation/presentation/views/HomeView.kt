package com.example.navigation.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.presentation.data.Student
import com.example.navigation.presentation.data.students

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Dashboard")
                }
            )
        }

    ){ paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 10.dp)
        ){
            items(students){ student ->
                Text("CONOCE AL ESTUDIANTE: ${student.name}")
                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("Details/${student.id}",)
                        }
                        .size(100.dp)
                        .background(color = Color.Yellow, CircleShape)
                        .wrapContentSize(Alignment.Center)
                ){
                    Text("Conocer el ID", color = Color.Black)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("Profile/${student.name}",)
                        }
                        .size(100.dp)
                        .background(color = Color.Blue, CircleShape)
                        .wrapContentSize(Alignment.Center)
                ){
                    Text("Conocer el nombre", color = Color.Black)
                }
            }
        }
    }
}