package com.example.cryptoassignment.presentation.empty_home.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.cryptoassignment.domain.model.EmptyHome
import com.example.cryptoassignment.domain.model.Home
import com.example.cryptoassignment.presentation.home.components.ButtonWithBorder

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CryptoBalanceEmpty(home: EmptyHome) {

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
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(20.dp)
        ) {
            ButtonWithBorder()
        }
    }
}