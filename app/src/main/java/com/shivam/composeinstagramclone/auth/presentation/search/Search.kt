package com.shivam.composeinstagramclone.auth.presentation.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Search(){
    Column(
        modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(start = 10.dp, end = 13.dp,top=10.dp)) {
            CustomTextField(
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        null,

                    )
                },
                trailingIcon = null,
                modifier = Modifier
                    .background(
                        MaterialTheme.colors.primary,
                        RoundedCornerShape(percent = 40)
                    )
                    .padding(5.dp)
                    .height(30.dp),
                fontSize = 17.sp,
                placeholderText = "    Search",

                )
        }
        val posts = ArrayList<String>()
        (0..26).forEach { index ->
            val post = "https://source.unsplash.com/random/400x300?$index"
            posts.add(post)
        }
        Spacer(modifier = Modifier.height(8.dp))
        PostSection(
            posts,
            modifier = Modifier.fillMaxWidth()
        )

    }

}

@Composable
private fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder",
    fontSize: TextUnit = MaterialTheme.typography.body2.fontSize
) {
    var text by remember { mutableStateOf("") }
    BasicTextField(modifier = modifier
        .background(
            MaterialTheme.colors.primary,
            MaterialTheme.shapes.medium,
        )
        .fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colors.primary),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colors.onSurface,
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) Text(
                        fontWeight = FontWeight.Thin,
                        text = placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colors.onSurface,
                            fontSize = fontSize
                        )
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<String>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = rememberAsyncImagePainter(posts[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)

            )
        }
    }
}