package com.app.moviekuapp.data.model.network

import com.app.moviekuapp.data.model.entity.Genre
import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("genres")
    override var results: List<Genre>
) : BaseListResponse<Genre>
