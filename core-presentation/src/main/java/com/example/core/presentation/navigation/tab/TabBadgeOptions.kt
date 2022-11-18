package com.example.core.presentation.navigation.tab

//or sealed class with different types?
//t/f, int, string, smthelse ?
data class TabBadgeOptions(
    val state: Boolean = false,
    val count: Int? = -1
)
