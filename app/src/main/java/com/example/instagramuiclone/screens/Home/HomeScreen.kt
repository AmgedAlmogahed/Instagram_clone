package com.example.instagramuiclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.instagramuiclone.screens.Home.HomeViewModel
import com.example.instagramuiclone.model.PostsData
import com.example.instagramuiclone.model.StoryData
import com.example.instagramuiclone.ui.theme.InstagramUICloneTheme
import com.example.instagramuiclone.ui.theme.LightBlue

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel(), navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(navController)
//        Story()
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            items(homeViewModel.stories) { data ->
                Story(data)
            }
        }
        LazyColumn() {
            items(homeViewModel.posts) { data ->
                Posts(data)
            }
        }
    }
}

@Composable
fun Story(data: StoryData) {
    Column(
        modifier = Modifier.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        RoundImage(
            image = painterResource(id = data.imageId), modifier = Modifier
                .size(70.dp)
        )
        Text(
            text = stringResource(id = data.usernameId),
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun Posts(data: PostsData? = null) {
    Column() {
        if (data != null) {
            PostHeader(
                data.image,
                data.username
            )
        }
        Image(
            painter = painterResource(id = data?.postImage!![0]),
            contentDescription = "image",
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        PostReactionBar()
        data.let {
            PostDescription(
                likedBy = data.likedBy,
                otherCount = 33,
                it.image
            )
        }
    }
}

@Composable
fun Header(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.camera_icon),
            contentDescription = "Camera Icon",
            modifier = Modifier.padding(start = 18.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.instagram_logo),
            contentDescription = stringResource(
                id = R.string.instagram_logo
            ),
            modifier = Modifier
                .width(105.dp)
                .height(30.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.igtv),
                contentDescription = "IGTV",
                tint = Color.Unspecified
            )
            IconButton(onClick = {
                navController.navigate("messages")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.messanger),
                    contentDescription = "Messages Icon",
                    modifier = Modifier.padding(end = 18.dp, start = 10.dp),
                    )
            }
        }
    }
}

@Composable
fun PostHeader(
    image: Int,
    username: String
) {
    Row(
        horizontalArrangement = SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(image = painterResource(id = image), modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = username)
        }
        Icon(
            painter = painterResource(id = R.drawable.options),
            contentDescription = "options",
        )
    }
}


@Composable
fun PostReactionBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.wrapContentWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "like button",
            )
            Icon(
                painter = painterResource(id = R.drawable.comment),
                contentDescription = "comment button",
                Modifier.padding(horizontal = 20.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.send),
                contentDescription = "send button"
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.pagination),
            contentDescription = "pagination",
            Modifier.padding(end = 50.dp),
            tint = LightBlue
        )
        Icon(
            painter = painterResource(id = R.drawable.save),
            contentDescription = "save button"
        )

    }
}


@Composable
fun PostDescription(
    likedBy: List<String>,
    otherCount: Int,
    image: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Row(
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        RoundImage(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(20.dp),
            image = painterResource(id = image)
        )
        if (likedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Liked by ")
                    likedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < likedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    InstagramUICloneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
//            HomeScreen()
        }
    }
}

@Preview
@Composable
fun PostPreview() {
    InstagramUICloneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Posts()
        }
    }
}