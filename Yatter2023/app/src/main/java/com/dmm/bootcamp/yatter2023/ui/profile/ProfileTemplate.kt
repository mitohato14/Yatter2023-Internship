package com.dmm.bootcamp.yatter2023.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dmm.bootcamp.yatter2023.domain.model.Me
import com.dmm.bootcamp.yatter2023.ui.profile.bindingmodel.ProfileUiState
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme


@Composable
fun ProfileTemplate(uiState: ProfileUiState) {
    uiState.me?.let {
        Column {
            Header(it)
            Profile(it)
            Spacer(modifier = Modifier.height(16.dp))

            var selectedTabIndex by remember { mutableStateOf(0) }
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.height(40.dp),
                contentColor = Yatter2023Theme.colors.primary,
                backgroundColor = Yatter2023Theme.colors.background
            ) {
                Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                    Text(text = "ツイート", style = Yatter2023Theme.typography.subtitle2)
                }
                Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }) {
                    Text(text = "ツイートと返信", style = Yatter2023Theme.typography.subtitle2)
                }
                Tab(selected = selectedTabIndex == 2, onClick = { selectedTabIndex = 2 }) {
                    Text(text = "メディア", style = Yatter2023Theme.typography.subtitle2)
                }
                Tab(selected = selectedTabIndex == 3, onClick = { selectedTabIndex = 3 }) {
                    Text(text = "いいね", style = Yatter2023Theme.typography.subtitle2)
                }
            }
        }
    }
}

@Composable
fun Header(me: Me) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(248.dp)
    ) {
        AsyncImage(
            model = me.header.toString(),
            contentDescription = "header",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillWidth
        )

        IconButton(
            onClick = { },
            modifier = Modifier
                .padding(8.dp)
                .background(Yatter2023Theme.colors.background.copy(alpha = 0.5f) , CircleShape)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        AsyncImage(
            model = me.avatar.toString(),
            contentDescription = "avatar",
            modifier = Modifier
                .padding(start = 8.dp)
                .height(96.dp)
                .clip(CircleShape)
                .border(4.dp, Yatter2023Theme.colors.background, CircleShape)
                .align(Alignment.BottomStart)
        )

        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(48.dp))
                .background(Yatter2023Theme.colors.primary)
                .clickable {  }
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = "変更" ,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                color = Yatter2023Theme.colors.onPrimary
            )
        }
    }
}

@Composable
fun Profile(me: Me) {
    Text(
        text = me.displayName ?: me.username.value,
        modifier = Modifier.padding(start = 16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp
    )
    Text(
        text = me.id.value,
        modifier = Modifier.padding(start = 16.dp),
        fontSize = 14.sp,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = me.note ?: "",
        modifier = Modifier.padding(start = 16.dp),
        fontSize = 14.sp,
    )
    Row(
        modifier = Modifier.padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("${me.followingCount}")
                }
                withStyle(style = SpanStyle()) {
                    append("フォロー中")
                }
            },
            fontSize = 14.sp,
        )

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("${me.followerCount}")
                }
                withStyle(style = SpanStyle()) {
                    append("フォロワー")
                }
            },
            fontSize = 14.sp,
        )
    }
}