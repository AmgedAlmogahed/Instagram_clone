package com.example.instagramuiclone.data

import android.annotation.SuppressLint
import com.example.instagramuiclone.R
import com.example.instagramuiclone.model.StoryData

class StoryDataSource {

        companion object {
            @SuppressLint("ResourceType")
            fun LoadItems(): List<StoryData> {
                return listOf(
                    StoryData(R.drawable.story1, R.string.yutta),
                    StoryData(R.drawable.story1, R.string.yutta),
                    StoryData(R.drawable.story1, R.string.yutta),
                    StoryData(R.drawable.story1, R.string.yutta),
                    StoryData(R.drawable.story1, R.string.yutta),
                    StoryData(R.drawable.story1, R.string.yutta)
                    )
            }
        }

    }
