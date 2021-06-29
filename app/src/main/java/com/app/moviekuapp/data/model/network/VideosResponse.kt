package com.app.moviekuapp.data.model.network

import com.app.moviekuapp.data.model.entity.Video
import com.google.gson.annotations.SerializedName

data class VideosResponse(
    @SerializedName("results")
    override var results: List<Video>
) : BaseListResponse<Video>
