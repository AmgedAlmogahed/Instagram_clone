package com.example.instagramuiclone.screens.profile

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.instagramuiclone.data.MessagesDataSource
import com.example.instagramuiclone.data.ProfileDataSource
import com.example.instagramuiclone.model.MessagesData

class ProfileViewModel : ViewModel() {

    private val _profilePosts = ProfileDataSource.postsList().toMutableStateList()
    val profilePosts: List<Int>
        get() = _profilePosts
}