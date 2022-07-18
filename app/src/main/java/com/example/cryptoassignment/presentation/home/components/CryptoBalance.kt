package com.example.cryptoassignment.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.example.cryptoassignment.domain.model.EmptyHome
import com.example.cryptoassignment.domain.model.Home

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CryptoBalance(home: Home) {

    val url = home.your_crypto_holdings[0].logo

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .componentRegistry {
            add(SvgDecoder(LocalContext.current))
        }
        .build()


    val paddingModifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()

    val paddingModifierText = Modifier
        .padding(5.dp)
        .fillMaxWidth()
    
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(30.dp))
    Card(
        elevation = 2.dp,
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
                Text(text = home.crypto_balance.title,
                    modifier = paddingModifierText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(text = home.crypto_balance.subtitle,
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
            Text(text = "$" + home.crypto_balance.current_bal_in_usd,
                modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Row() {

                Text(text = "$300.22 (+21.51%)",
                    modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 10.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xC4009688),
                    fontSize = 12.sp
                )
            }
        }
        
    }
}
