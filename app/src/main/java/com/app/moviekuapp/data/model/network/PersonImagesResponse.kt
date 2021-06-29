package com.app.moviekuapp.data.model.network

import com.app.moviekuapp.data.model.entity.Image
import com.google.gson.annotations.SerializedName

data class PersonImagesResponse(
    @SerializedName("profiles")
    override var results: List<Image>
) : BaseListResponse<Image>