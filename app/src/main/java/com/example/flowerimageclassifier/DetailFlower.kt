package com.example.flowerimageclassifier


import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.common.util.Log
// class to display the flower details
@Composable
fun DetailFlower(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    cultivation: Array<String>,
    link: Array<String>,
    toxicity: Array<Boolean>,
    itemIndex: Int?
) {


    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // flower image
            Image(
                painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = names[itemIndex],
                modifier.size(200.dp)
            )
        }
        // flower details
        Text(text = names[itemIndex!!], fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "\nGrowing Conditions:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = cultivation[itemIndex], fontSize = 18.sp)
        Text(text = "\nFlower Toxicity:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        if (toxicity[itemIndex]) {
            Text(
                text = "Be careful when handling this flower because it is toxic!",
                fontSize = 18.sp
            )
        }
        else {
            Text(
                text = "This flower is not toxic to humans and will not cause them any harm.",
                fontSize = 18.sp
            )
        }
        // wikipedia link for each flower
        Text(text = "\nFind out more:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        val annotatedLinkString: AnnotatedString = buildAnnotatedString {

            val str = "Click this link to learn more about this flower!"
            val startIndex = 0
            val endIndex = str.length
            append(str)
            addStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline
                ), start = startIndex, end = endIndex
            )

            // attach a string annotation that stores a URL to the text "link"
            addStringAnnotation(
                tag = "URL",
                annotation = link[itemIndex],
                start = startIndex,
                end = endIndex
            )

        }

        // UriHandler parse and opens URI inside AnnotatedString Item in Browse
        val uriHandler = LocalUriHandler.current

        //  Clickable text returns position of text that is clicked in onClick callback
        ClickableText(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = annotatedLinkString,
            onClick = {
                annotatedLinkString
                    .getStringAnnotations("URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            }
        )

    }

}