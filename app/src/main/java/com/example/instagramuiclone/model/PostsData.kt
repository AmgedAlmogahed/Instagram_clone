package com.example.instagramuiclone.model

import androidx.compose.ui.graphics.painter.Painter

data class PostsData(
    val image: Int,
    val username: String,
    val postImage: List<Int>,
    val likedBy: List<String>,
    val description: String,
)
