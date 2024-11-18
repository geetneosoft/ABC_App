package com.app.abc.presentation.home.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Size
import com.app.abc.R
import com.app.abc.data.model.Article
import com.app.abc.util.Constants
import com.app.abc.util.convertDateOneFormatToAnother

@Composable
fun NewsArticleItem(data: Article, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_12)))
            .padding(
                dimensionResource(id = R.dimen.dp_10)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.urlToImage ?: data.url?:"")
                .size(Size.ORIGINAL)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.baseline_no_encryption_gmailerrorred_24),
            placeholder = painterResource(R.drawable.baseline_no_encryption_gmailerrorred_24),
            contentDescription = stringResource(R.string.article),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.dp_55))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_10))),
            onError = {
                Log.e("TAG", "NewsArticleItem: Error ${it.result.throwable.message}" )
            },
            onSuccess = {
                Log.e("TAG", "NewsArticleItem: Success" )
            }
        )
        Column(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.dp_10))) {
            Text(text = data.title,
                fontSize = 15.sp, fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier=Modifier.fillMaxWidth()
            )
            Text(
                text = data.publishedAt.convertDateOneFormatToAnother(Constants.DATE_PATTERN1, Constants.DATE_PATTERN2)?:"NAN",
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                letterSpacing = 0.sp,
                lineHeight = 14.sp
            )
        }
    }
}

@Preview(uiMode = 0)
@Composable
private fun Preview() {
    NewsArticleItem(
        modifier = Modifier.fillMaxWidth(),
        data = Article(title = "Title",
            "","","")
    )
}

