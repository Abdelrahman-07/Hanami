package com.example.flowerimageclassifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// class that displays the cards for each disease
@Composable
fun MainDisease(
    imageId: Array<Int>,
    names: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = imageId.size
        //display a card for each disease
        items(itemCount) {
            DiseaseColumnItem(
                modifier,
                painter = imageId,
                title = names,
                itemIndex = it,
                navController = navController
            )
        }
    }

}

@Composable
fun DiseaseColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    itemIndex: Int,
    navController: NavController
) {

        // card design
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route= "DetailDisease/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(100.dp)
            )
            Column(modifier.padding(22.dp)) {
                Text(text = title[itemIndex], fontSize = 20.sp, fontWeight = FontWeight.Bold)


            }
        }
    }
}