package com.app.moviekuapp.data.model.network

import com.app.moviekuapp.data.model.entity.Movie
import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    @SerializedName("page")
    override var page: Int,

    @SerializedName("results")
    override var results: List<Movie>
) : BasePageListResponse<Movie>
