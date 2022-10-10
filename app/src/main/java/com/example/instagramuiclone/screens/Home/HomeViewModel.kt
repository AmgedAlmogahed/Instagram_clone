package com.example.instagramuiclone.screens.Home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.instagramuiclone.data.PostsDataSource
import com.example.instagramuiclone.data.StoryDataSource
import com.example.instagramuiclone.model.PostsData
import com.example.instagramuiclone.model.StoryData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _stories = StoryDataSource.LoadItems().toMutableStateList()
    val stories: List<StoryData>
        get() = _stories

    private val _posts = PostsDataSource.LoadItems().toMutableStateList()
    val posts: List<PostsData>
        get() = _posts


}