package com.example.starwarsmvpapp.main.model.characters


import com.google.gson.annotations.SerializedName

data class StarChars(
    @SerializedName("name")
    val name: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("url")
    val url: String
)