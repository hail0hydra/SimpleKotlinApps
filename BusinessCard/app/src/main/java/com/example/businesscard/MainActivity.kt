package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainCard(
                        name = stringResource(R.string.full_name),
                        title = stringResource(R.string.title),
                        detailA = stringResource(R.string.phone_number),
                        detailB = stringResource(R.string.github),
                        detailC = stringResource(R.string.email),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainCard(
    name: String,
    title: String,
    detailA: String,
    detailB: String,
    detailC: String,
    modifier: Modifier = Modifier
) {
    Box{
        BackDropImage()
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ProfileTop(
                name = name,
                title = title
            )
            Spacer(modifier = Modifier.height(200.dp))
            ProfileBottom(
                detailA = detailA,
                detailB = detailB,
                detailC = detailC,
                modifier = Modifier.padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun ProfileBottom(detailA: String,
                  detailB: String,
                  detailC: String,
                  modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        AboutItems(
            detail = detailA, iconRes = R.drawable.outline_add_call_24
        )
        AboutItems(
            detail = detailB, iconRes = R.drawable.octicons_mark_github
        )
        AboutItems(
            detail = detailC, iconRes = R.drawable.email
        )
    }
}


@Composable
fun AboutItems(detail: String, @DrawableRes iconRes: Int, modifier: Modifier = Modifier) {
    val icon = painterResource(id = iconRes)

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(16.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null
        )
        Text(
            text = detail,
            modifier = modifier.padding(start = 40.dp)
        )
    }
}




@Composable
fun ProfileTop(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        //modifier = Modifier.fillMaxSize()
    ) {
        ProfileIcon()

        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 1.dp, bottom = 8.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ProfileIcon( modifier: Modifier = Modifier) {
    //val icon = painterResource(R.drawable.ic_launcher_foreground)
    val icon = painterResource(R.drawable.punk)
    Icon(
        painter = icon,
        contentDescription = null
    )
}



@Composable
fun BackDropImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.anture)

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.56F
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainCard(
                name = stringResource(R.string.full_name),
                title = stringResource(R.string.title),
                detailA = stringResource(R.string.phone_number),
                detailB = stringResource(R.string.github),
                detailC = stringResource(R.string.email),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}