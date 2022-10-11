package com.shivam.composeinstagramclone.auth.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.shivam.composeinstagramclone.auth.model.Story
import com.shivam.composeinstagramclone.auth.model.currentUser
import com.shivam.composeinstagramclone.auth.model.names


object StoriesRepository {
  private val stories = mutableStateOf<List<Story>>(emptyList())

  private fun populateStories() {



    val _stories = ArrayList<Story>()

    _stories.add(
        Story(
            image = currentUser.image,
            name = "Your Story"
        )
    )

    (0..9).forEach { index ->
      val story = Story(
          image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg",
          name = names[index]
      )
      _stories.add(story)
    }

    stories.value = _stories
  }

  init {
    populateStories()
  }

  fun observeStories(): MutableState<List<Story>> = stories

}