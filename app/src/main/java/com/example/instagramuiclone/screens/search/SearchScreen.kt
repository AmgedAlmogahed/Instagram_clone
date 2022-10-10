package com.example.instagramuiclone.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagramuiclone.screens.components.GridImages
import com.example.instagramuiclone.screens.components.SearchBar
import com.example.instagramuiclone.screens.search.SearchViewModel
import com.example.instagramuiclone.ui.theme.InstagramUICloneTheme

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = viewModel()
) {
    Column() {
        SearchBar(modifier = Modifier.padding(vertical = 10.dp))
        GridImages(images = searchViewModel.searchPosts)
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun SearchPreview() {
    InstagramUICloneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SearchScreen()
        }
    }
}