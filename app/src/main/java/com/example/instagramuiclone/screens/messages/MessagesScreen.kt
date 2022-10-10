package com.example.instagramuiclone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagramuiclone.data.MessagesDataSource
import com.example.instagramuiclone.model.MessagesData
import com.example.instagramuiclone.screens.messages.MessagesViewModel
import com.example.instagramuiclone.ui.theme.InstagramUICloneTheme

@Composable
fun Messages(
    messagesViewModel: MessagesViewModel = viewModel()
) {
    Column {
        MessagesHeader(username = "amged.almogahed.1")
        SearchBar()
        Spacer(modifier = Modifier.size(10.dp))
        LazyColumn{
            items(messagesViewModel.messages) { data ->
                MessageItems(data = data)
            }
        }
    }
}

@Composable
fun MessagesHeader(
    username: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
            contentDescription = "back button"
        )
        Row {
            Text(text = username)
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                contentDescription = "down arrow"
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = "add button"
        )
    }
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(40.dp)
            .wrapContentHeight(CenterVertically),
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

@Composable
fun MessageItems(
    modifier: Modifier = Modifier,
    data: MessagesData
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Row(
            verticalAlignment = CenterVertically
        ) {
            RoundImage(image = painterResource(id = data.imageId),  modifier = Modifier.padding(horizontal = 10.dp).size(70.dp))
            Column {
                Text(text = data.username, fontWeight = FontWeight.Bold)
                Text(text = data.message, fontWeight = FontWeight.Light)
            }
        }
        Row(modifier = Modifier.padding(end = 10.dp, top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = data.lastSeen,
                modifier = Modifier
                    .padding(end = 10.dp, bottom = 13.dp)
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.Bottom),
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Icon(
                painter = painterResource(id = R.drawable.camera_icon),
                contentDescription = "Camera Icon",
                modifier = Modifier.padding(start = 10.dp),
                tint = Color.Gray
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MessagesPreview() {
    InstagramUICloneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Messages()
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun MessageItemPreview() {
//    InstagramUICloneTheme {
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            color = MaterialTheme.colors.background
//        ) {
//
//        }
//    }
//}