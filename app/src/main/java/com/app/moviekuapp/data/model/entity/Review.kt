package com.app.moviekuapp.data.model.entity

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("id")
    var id: String,

    @SerializedName("author")
    var author: String,

    @SerializedName("content")
    var content: String,
)