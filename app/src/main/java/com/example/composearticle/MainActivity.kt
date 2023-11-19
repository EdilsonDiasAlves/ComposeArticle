package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article()
                }
            }
        }
    }
}

@Composable
fun Article() {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Column(verticalArrangement = Arrangement.Top) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        ArticleTitle(
            content = stringResource(R.string.article_title)
        )
        ArticleSession(
            content = stringResource(R.string.first_session)
        )
        ArticleSession(
            content = stringResource(R.string.second_session),
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    bottom = 16.dp
                )
        )
    }
}

@Composable
fun ArticleTitle(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun ArticleSession(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Article()
    }
}