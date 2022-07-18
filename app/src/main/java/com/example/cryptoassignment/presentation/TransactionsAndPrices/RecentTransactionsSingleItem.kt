package com.example.cryptoassignment.presentation.TransactionsAndPrices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.example.cryptoassignment.data.remote.dto.AllTransaction

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RecentTransactionsSingleItem(
    recentTransaction: AllTransaction
) {

    val url = recentTransaction.txn_logo
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .componentRegistry {
            add(SvgDecoder(LocalContext.current))
        }
        .build()
    val paddingModifier = Modifier
        .padding(start = 15.dp, end = 15.dp)
        .fillMaxWidth()

    val paddingModifierText = Modifier
        .padding(5.dp)
        .fillMaxWidth()

    Card(
        elevation = 4.dp,
        modifier = paddingModifier
    ) {

        Row {

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                CompositionLocalProvider(LocalImageLoader provides imageLoader) {
                    val painter = rememberImagePainter(url)

                    Image(
                        painter = painter,
                        contentDescription = "SVG Image",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
            ) {
                Text(text = recentTransaction.title,
                    modifier = paddingModifierText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(text = recentTransaction.txn_time,
                    modifier = paddingModifierText,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp)
            }
        }
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        ) {
            Text(text = "$" + recentTransaction.txn_amount,
                modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Row() {
                Text(text = "$" + recentTransaction.txn_sub_amount,
                    modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 10.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xC4009688),
                    fontSize = 12.sp
                )
            }
        }
    }
}