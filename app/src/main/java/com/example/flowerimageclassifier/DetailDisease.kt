package com.example.flowerimageclassifier



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// class to display the disease details
@Composable
fun DetailDisease(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    description: Array<String>,
    treatment: Array<String>,
    itemIndex: Int?
) {


    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Box(modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            //  disease image
            Image(painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = names[itemIndex],
                modifier.size(200.dp)
            )
        }
        // disease details
        Text(text = names[itemIndex!!], fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "Description:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = description[itemIndex], fontSize = 18.sp)
        Text(text = "Treatment:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = treatment[itemIndex], fontSize = 18.sp)
    }
}