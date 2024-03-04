package org.sopt.mvi_clone_coding.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NextEvolution(
    @SerialName("name")
    val name: String,
    @SerialName("num")
    val num: String
)