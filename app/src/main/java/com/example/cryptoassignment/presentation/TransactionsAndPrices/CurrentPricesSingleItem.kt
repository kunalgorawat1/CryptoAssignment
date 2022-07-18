package com.example.cryptoassignment.presentation.TransactionsAndPrices

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.example.cryptoassignment.data.remote.dto.CryptoPrice
import com.example.cryptoassignment.presentation.home.components.ButtonWithBorder
import com.example.cryptoassignment.presentation.home.components.SimpleButton

@Composable
fun CurrentBalanceSingleItem(
    prices: CryptoPrice
) {
    val url = prices.logo

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
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .size(150.dp)
    ) {


        Row (
            modifier = Modifier
                .padding(10.dp)
        ){

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            ) {

                CompositionLocalProvider(LocalImageLoader provides imageLoader) {
                    val painter = rememberImagePainter(url)

                    Image(
                        painter = painter,
                        contentDescription = "SVG Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(30.dp)
                    )
                }
                Text(text = prices.title,
                    modifier = paddingModifierText,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp
                )
                Text(text = "$" + prices.current_price_in_usd,
                    modifier = paddingModifierText,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp)
            }

        }
    }
}