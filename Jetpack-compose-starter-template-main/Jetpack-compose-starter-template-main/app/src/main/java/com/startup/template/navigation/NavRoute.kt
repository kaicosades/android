package com.startup.template.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute : NavKey

@Serializable
data class DetailsRoute(
    val parameter: String,
) : NavKey

