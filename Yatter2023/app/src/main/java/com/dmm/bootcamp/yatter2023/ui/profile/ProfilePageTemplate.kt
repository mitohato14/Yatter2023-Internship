package com.dmm.bootcamp.yatter2023.ui.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProfilePageTemplate(uiState: ProfileUiState) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Column(modifier = Modifier.fillMaxSize()) Me@{
                val me = uiState.me ?: return@Me

                Box(modifier = Modifier.height(248.dp)){
                    AsyncImage(
                        model = me.header.toString(),
                        contentDescription = "background",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    AsyncImage(
                        model = me.avatar.toString(),
                        contentDescription = "avatar",
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 16.dp)
                            .size(96.dp)
                            .clip(CircleShape)
                            .border(8.dp, Color.White, shape = CircleShape),
                    )

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 16.dp)
                            .wrapContentSize()
                            .clip(RoundedCornerShape(48.dp))
                    ){
                        Text("プロフィールを編集")
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Column {
                        Text(
                            text = me.displayName ?: me.username.value,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp
                        )
                        Text(
                            text = me.id.value,
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = me.note?: "",
                        fontSize = 14.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                                    append("${me.followingCount}")
                                }
                                withStyle(SpanStyle(color = Color.Gray)) {
                                    append("フォロー")
                                }
                            },
                            fontSize = 14.sp
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                                    append("${me.followerCount}")
                                }
                                withStyle(SpanStyle(color = Color.Gray)) {
                                    append("フォロワー")
                                }
                            },
                            fontSize = 14.sp
                        )
                    }
                }
            }

            if (uiState.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}