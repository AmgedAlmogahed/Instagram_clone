package com.example.instagramuiclone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.instagramuiclone.R
import com.example.instagramuiclone.ui.theme.InstagramUICloneTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.instagram_logo),
            contentDescription = "logo",
            Modifier.padding(vertical = 30.dp)
        )

        TextFieldArea("", {}, "username", 10, Modifier)
        Spacer(modifier = Modifier.size(10.dp))
        TextFieldArea("", {}, "password", 10, Modifier)
        Text(
            text = "Forget Password?",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .padding(top = 10.dp, end = 20.dp, bottom = 20.dp),
            color = Color(0xFF3797EF),

            )
        Button(
            onClick = {
                      navController.navigate("home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0x883797EF))
        )
        {
            Text(text = "Login", modifier = Modifier.padding(5.dp), color = Color(0xFFFFFFFF))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.facebook_icon),
                contentDescription = "facebook icon",
                tint = Color(0xFF3797EF)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Login with facebook ")
        }
        Text(text = "OR", Modifier.padding(vertical = 30.dp))
        Row {
            Text(text = "Don't have an account?")
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "Sign Up.", color = Color(0xFF3797EF))
        }
    }

}

@Composable
fun TextFieldArea(
    value: String = "",
    onValueChanged: (String) -> Unit,
    label: String,
    corners: Int,
    modifier: Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(60.dp)
            .wrapContentHeight(Alignment.CenterVertically),
        shape = RoundedCornerShape(corners),
        label = {
            Text(text = label, color = Color(0x55000000))
        }, colors = TextFieldDefaults.textFieldColors(
            backgroundColor = (Color(0xFFFAFAFA))
        )


    )
}

@Preview
@Composable
fun Preview() {
    InstagramUICloneTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {

//            LoginScreen()
        }
    }
}
