package com.example.instagramuiclone.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramuiclone.R

@ExperimentalFoundationApi
@Composable
fun GridImages(
    images: List<Int>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(images.size) {
            Image(
                painter = painterResource(id = images[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 0.5.dp,
                        color = Color.White
                    )
            )
        }
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
//    Card(
//        elevation = 10.dp,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
//            .height(40.dp),
//        shape = RoundedCornerShape(25),
//
//        ) {

    TextField(
        value = "",
        onValueChange = { },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(40.dp)
            .wrapContentHeight(Alignment.CenterVertically),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "search icon",
                modifier = Modifier
            )
        },
        label = {
            Text(
                text = "Search",
                color = Color(0x55000000),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 5.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = (Color(0x23757575))
        ),
        shape = RoundedCornerShape(15.dp)


    )
}