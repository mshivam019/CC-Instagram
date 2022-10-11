package com.shivam.composeinstagramclone.auth.presentation.mainscreen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.shivam.composeinstagramclone.R
import com.shivam.composeinstagramclone.auth.model.currentUser
import com.ramcosta.composedestinations.annotation.Destination
import com.shivam.composeinstagramclone.auth.presentation.mainscreen.HomeSection.Search
import com.shivam.composeinstagramclone.auth.presentation.mainscreen.HomeSection.Activity
import com.shivam.composeinstagramclone.auth.presentation.mainscreen.HomeSection.Home
import com.shivam.composeinstagramclone.auth.presentation.mainscreen.HomeSection.Profile
import com.shivam.composeinstagramclone.auth.presentation.mainscreen.HomeSection.Reels
import com.shivam.composeinstagramclone.common.components.bottomBarHeight
import com.shivam.composeinstagramclone.common.components.icon
import com.shivam.composeinstagramclone.auth.presentation.home.Home
import com.shivam.composeinstagramclone.auth.presentation.profile.Profile
import com.shivam.composeinstagramclone.auth.presentation.reels.Reels
import com.shivam.composeinstagramclone.auth.presentation.search.Search
import com.shivam.composeinstagramclone.auth.presentation.activity.Activity


@ExperimentalFoundationApi
@Destination
@Composable
fun MainScreen(navigator: DestinationsNavigator) {

    val sectionState = remember { mutableStateOf(Home) }

    val navItems = HomeSection.values()
      .toList()
  Scaffold(
      bottomBar = {
        BottomBar(
            items = navItems,
            currentSection = sectionState.value,
            onSectionSelected = { sectionState.value = it},
        )
      }) { innerPadding ->
    val modifier = Modifier.padding(innerPadding)
    Crossfade(
        modifier = modifier,
        targetState = sectionState.value)
    { section ->
        when (section) {
            Home -> Home()
            Reels -> Reels()
            Search -> Search()
            Activity -> Activity()
            Profile -> Profile()
        }
    }
  }
}


@Composable
private fun BottomBar(
    items: List<HomeSection>,
    currentSection: HomeSection,
    onSectionSelected: (HomeSection) -> Unit,
) {
  BottomNavigation(
      modifier = Modifier.height(bottomBarHeight),
      backgroundColor = MaterialTheme.colors.background,
      contentColor = contentColorFor(MaterialTheme.colors.background)
  ) {
    items.forEach { section ->

      val selected = section == currentSection

      val iconRes = if (selected) section.selectedIcon else section.icon

      BottomNavigationItem(
          icon = {

            if (section == Profile) {
              BottomBarProfile(selected)
            } else {
              Icon(
                  ImageBitmap.imageResource(id = iconRes),
                  modifier = Modifier.icon(),
                  contentDescription = ""
              )
            }

          },
          selected = selected,
          onClick = { onSectionSelected(section) },
          alwaysShowLabel = false
      )
    }
  }
}

@Composable
private fun BottomBarProfile(isSelected: Boolean) {
    val db = FirebaseFirestore.getInstance()
    var imageUri by remember { mutableStateOf("") }
    db.collection("users").document(FirebaseAuth.getInstance().currentUser!!.uid)
        .get().addOnCompleteListener { task: Task<DocumentSnapshot?> ->
            if (task.isSuccessful && task.result != null) {
                imageUri = task.result!!.getString("imageUrl").toString()
                currentUser.image=imageUri
            } else {
                //deal with error
            }
        }
  val shape = CircleShape

  val borderModifier = if (isSelected) {
    Modifier
        .border(
            color = Color.LightGray,
            width = 1.dp,
            shape = shape
        )
  } else Modifier

  val padding = if (isSelected) 3.dp else 0.dp

  Box(
      modifier = borderModifier
  ) {
    Box(
        modifier = Modifier
            .icon()
            .padding(padding)
            .background(color = Color.LightGray, shape = shape)
            .clip(shape)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUri),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
  }

}

private enum class HomeSection(
  val icon: Int,
  val selectedIcon: Int
) {
  Home(R.drawable.ic_outlined_home, R.drawable.ic_filled_home),
    Search(R.drawable.ic_outlined_search, R.drawable.ic_outlined_search),
  Reels(R.drawable.ic_outlined_reels, R.drawable.ic_filled_reels),
  Activity(R.drawable.ic_outlined_favorite, R.drawable.ic_filled_favorite),
  Profile(R.drawable.ic_outlined_reels, R.drawable.ic_outlined_reels)
}

