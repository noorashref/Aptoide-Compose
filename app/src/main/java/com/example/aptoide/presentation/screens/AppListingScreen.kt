package com.example.aptoide.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aptoide.presentation.component.AppListItem
import com.example.aptoide.presentation.viewmodel.AppListViewModel
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.aptoide.presentation.component.LocalTopCard

@Composable
fun AppListingScreen(
    navController: NavController,
    viewModel: AppListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(
        modifier = Modifier.padding(top = 15.dp),
    ) {
        Text(
            text = "Editors choice", fontSize = 20.sp, modifier = Modifier.padding(start = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .layoutId("mainbox"),
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                items(state.appListing) { appLists ->
                    AppListItem(
                        appListModel = appLists,
                        onItemClick = {
                            navController.navigate(Screen.AppDetailScreen.route + "/${appLists.id}")
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Column(
            modifier = Modifier.padding(top = 15.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Text(text = "Local top apps", fontSize = 20.sp, modifier = Modifier.padding(start = 8.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .layoutId("toplocal"),
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                val sortRatings = state.appListing.sortedByDescending {
                    it.rating
                }
//                items(state.appListing) { appLists ->
                items(sortRatings) { appLists ->

                    LocalTopCard(
                        appListModel = appLists,
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }

    }


}