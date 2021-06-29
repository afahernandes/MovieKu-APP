package com.app.moviekuapp.data.model.network

import com.app.moviekuapp.data.model.entity.Review
import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("results")
    override var results: List<Review>
) : BaseListResponse<Review>
