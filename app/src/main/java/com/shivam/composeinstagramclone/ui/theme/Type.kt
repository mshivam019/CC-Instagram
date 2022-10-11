package com.shivam.composeinstagramclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shivam.composeinstagramclone.R

val sfUIDisplay = FontFamily(
    listOf(
        Font(R.font.sf_ui_display_bold),
        Font(R.font.sf_ui_display_medium),
        Font(R.font.sf_ui_display_light),
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = sfUIDisplay,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp
    ),
    h1 = TextStyle(
        fontFamily = sfUIDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        fontFamily = sfUIDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    button = TextStyle(
        fontFamily = sfUIDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    /* Other default text styles to override

    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)