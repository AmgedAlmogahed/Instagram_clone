package com.example.instagramuiclone.screens.messages

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.instagramuiclone.data.MessagesDataSource
import com.example.instagramuiclone.model.MessagesData
import com.example.instagramuiclone.model.StoryData

class MessagesViewModel  : ViewModel() {

    private val _messages = MessagesDataSource.LoadItems().toMutableStateList()
    val messages: List<MessagesData>
        get() = _messages
}