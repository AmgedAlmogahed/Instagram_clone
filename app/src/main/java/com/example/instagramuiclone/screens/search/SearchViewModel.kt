package com.example.instagramuiclone.screens.search

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.instagramuiclone.data.MessagesDataSource
import com.example.instagramuiclone.data.ProfileDataSource
import com.example.instagramuiclone.model.MessagesData

class SearchViewModel : ViewModel() {

    private val _searchPosts = ProfileDataSource.postsList().toMutableStateList()
    val searchPosts: List<Int>
        get() = _searchPosts
}