package com.zhasu.carouselandlist.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zhasu.carouselandlist.presentation.components.BottomSheetContent
import com.zhasu.carouselandlist.presentation.components.ImageCarousel
import com.zhasu.carouselandlist.presentation.components.ListItem
import com.zhasu.carouselandlist.presentation.components.SearchBar
import com.zhasu.carouselandlist.presentation.ui.theme.BlueLight
import com.zhasu.carouselandlist.presentation.ui.theme.CarouselAndListTheme
import com.zhasu.carouselandlist.presentation.viewmodels.FruitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val fruitViewModel = hiltViewModel<FruitViewModel>()
    val fruitList by fruitViewModel.fruits.collectAsStateWithLifecycle()

    val imagesOnly = fruitList.map { it.image }
    var searchQuery by remember { mutableStateOf("") }

    val filteredItems = remember(searchQuery, fruitList) {
        if (searchQuery.isEmpty()) {
            fruitList
        } else {
            fruitList.filter { it.title.contains(searchQuery, ignoreCase = true) }
        }
    }

    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showSheet = true },
                containerColor = BlueLight,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "Options")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                item {
                    ImageCarousel(imagesOnly)

                    SearchBar(
                        query = searchQuery,
                        onQueryChange = { searchQuery = it }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                if (filteredItems.isNotEmpty()) {

                    items(filteredItems, key = { it.id }) { natureItem ->
                        ListItem(natureItem)
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                } else {
                    item {
                        Text("No results found", modifier = Modifier.padding(16.dp))
                    }
                }

            }

        }

        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                BottomSheetContent(fruitList)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CarouselAndListTheme {
        MainScreen()
    }
}