package com.example.starwarsmvpapp.main.model.characters


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("message")
    val message: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val StarChars: List<StarChars>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_records")
    val totalRecords: Int
)