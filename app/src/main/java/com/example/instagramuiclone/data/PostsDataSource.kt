package com.example.instagramuiclone.data

import androidx.compose.ui.res.painterResource
import com.example.instagramuiclone.R
import com.example.instagramuiclone.model.PostsData
import com.example.instagramuiclone.model.StoryData

class PostsDataSource {
    companion object {
        fun LoadItems(): List<PostsData> {
            return listOf<PostsData>(
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post1),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                ),
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post2),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                ),
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post3),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                ),
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post4),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                ),
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post5),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                ),
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post6),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                ),
                PostsData(
                    image = R.drawable.amged,
                    username = "Amged Almogahed",
                    postImage = listOf(R.drawable.post7),
                    likedBy = listOf("Yuuta", "Saharsh"),
                    description = "The game in Japan was amazing and I want to share some photos",
                )

            )
        }
    }
}
