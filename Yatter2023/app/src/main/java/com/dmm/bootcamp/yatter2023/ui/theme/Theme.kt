package com.dmm.bootcamp.yatter2023.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

private val darkColorScheme = darkColors(
  primary = Orange20,
  secondary = Red20,
)

private val lightColorScheme = lightColors(
  primary = Orange80,
  secondary = Red40,
)

@Composable
fun Yatter2023Theme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme =
    if (darkTheme) darkColorScheme else lightColorScheme

  MaterialTheme(
    colors = colorScheme,
    typography = Typography,
    content = content
  )
}

object Yatter2023Theme {
  val colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme

  val typography
    @Composable
    @ReadOnlyComposable
  get()= Typography
}