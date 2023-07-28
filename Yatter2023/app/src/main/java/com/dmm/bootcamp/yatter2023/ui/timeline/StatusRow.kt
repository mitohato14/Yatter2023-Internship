package com.dmm.bootcamp.yatter2023.ui.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel

@Composable
fun StatusRow(
    statusBindingModel: StatusBindingModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(48.dp),
            model = statusBindingModel.avatar,
            contentDescription = "アバター画像",
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Row {

                Text(
                    text = statusBindingModel.displayName,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "@${statusBindingModel.username}"
                    )
                }
            }
            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = statusBindingModel.content,
                fontSize = 14.sp,
                color = Color.DarkGray
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                statusBindingModel.attachmentMediaList.map {
                    AsyncImage(
                        modifier = Modifier.size(96.dp),
                        model = it.url,
                        contentDescription = it.description
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun StatusRowPreview() {
    Yatter2023Theme {
        Surface {
            StatusRow(
                statusBindingModel = StatusBindingModel(
                    id = "id",
                    displayName = "mito",
                    username = "mitohato14",
                    avatar = "https://avatars.githubusercontent.com/u/19385268?v=4",
                    content = "preview content",
                    attachmentMediaList = emptyList()
                )
            )
        }
    }
}