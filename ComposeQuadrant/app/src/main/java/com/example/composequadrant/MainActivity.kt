package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposedQuadrants(
                        titleA = stringResource(R.string.quad1_title), bodyA = stringResource(R.string.quad1_body),
                        titleB = stringResource(R.string.quad2_title), bodyB = stringResource(R.string.quad2_body),
                        titleC = stringResource(R.string.quad3_title), bodyC = stringResource(R.string.quad3_body),
                        titleD = stringResource(R.string.quad4_title), bodyD = stringResource(R.string.quad4_body),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ComposedQuadrants(titleA: String, bodyA: String,
                      titleB: String, bodyB: String,
                      titleC: String, bodyC: String,
                      titleD: String, bodyD: String,
                      modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier.fillMaxSize()
    ) {
        RowQuad(
            titleA = titleA, bodyA = bodyA, colorA = Color(0xFFEADDFF),
            titleB = titleB, bodyB = bodyB, colorB = Color(0xFFD0BCFF),
            modifier = Modifier.weight(1f)
        )
        RowQuad (
            titleA = titleC, bodyA = bodyC, colorA = Color(0xFFB69DF8),
            titleB = titleD, bodyB = bodyD, colorB = Color(0xFFF6EDFF),
            modifier = Modifier.weight(1f)
        )
    }

}


@Composable
fun RowQuad(titleA: String, bodyA: String, colorA: Color, titleB: String, bodyB: String, colorB: Color, modifier: Modifier = Modifier) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Quadrant(title = titleA, body = bodyA, modifier = Modifier.weight(1f), bgColor = colorA)
        Quadrant(title = titleB, body = bodyB, modifier = Modifier.weight(1f), bgColor =  colorB)
    }
}

@Composable
fun Quadrant(title: String, body: String, bgColor: Color, modifier: Modifier = Modifier) {

    Box (modifier = modifier
        .background(bgColor)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = body,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantsPreview() {
    ComposeQuadrantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ComposedQuadrants(
                titleA = stringResource(R.string.quad1_title), bodyA = stringResource(R.string.quad1_body),
                titleB = stringResource(R.string.quad2_title), bodyB = stringResource(R.string.quad2_body),
                titleC = stringResource(R.string.quad3_title), bodyC = stringResource(R.string.quad3_body),
                titleD = stringResource(R.string.quad4_title), bodyD = stringResource(R.string.quad4_body),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}