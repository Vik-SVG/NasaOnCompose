package com.priesniakov.nasaoncompose.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.priesniakov.core.theme.Black
import com.priesniakov.core.theme.Mercury2
import com.priesniakov.core.theme.TextAppBar
import com.priesniakov.core.theme.Vermilion
import com.priesniakov.core.theme.TabFadeInAnimationDelay
import com.priesniakov.core.theme.TabFadeInAnimationDuration
import com.priesniakov.core.theme.TabFadeOutAnimationDuration
import com.priesniakov.nasaoncompose.navigation.Screen
import com.priesniakov.nasaoncompose.navigation.rootScreenIcons

@Composable
fun NasaAppBar(title: String) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, style = TextAppBar)
        Spacer(modifier = Modifier.size(width = 36.dp, height = 0.dp))
    }
}

@Composable
fun NasaBottomBar(currentScreen: Screen, allScreens: List<Screen>, onSelected: (Screen) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Black,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            allScreens.forEachIndexed { _, screen ->
                SimpleTab(screen, currentScreen, onSelected)
            }
        }
    }
}


@Composable
fun SimpleTab(screen: Screen, currentScreen: Screen, onSelected: (Screen) -> Unit) {
    val selected = screen == currentScreen

    val tabBackgroundColor = Vermilion

    val durationMillis =
        if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration

    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis = TabFadeInAnimationDelay
        )
    }

    val iconTintColor by animateColorAsState(
        targetValue = if (selected) tabBackgroundColor else Mercury2,
        animationSpec = animSpec, label = "previewLabel"
    )
    Icon(
        modifier = Modifier
            .padding(8.dp)
            .animateContentSize()
            .selectable(
                selected = selected,
                onClick = { onSelected(screen) },
                role = Role.Tab,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = Color.Unspecified
                )
            )
            .clearAndSetSemantics { contentDescription = "" },
        painter = painterResource(id = rootScreenIcons.getValue(screen.route)),
        contentDescription = "", tint = iconTintColor
    )
}