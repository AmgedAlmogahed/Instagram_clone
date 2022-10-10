package com.example.instagramuiclone.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class StoryData(
    @DrawableRes val imageId: Int,
    @StringRes val usernameId: Int
)
