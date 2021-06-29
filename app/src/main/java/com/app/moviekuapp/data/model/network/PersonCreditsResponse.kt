package com.app.moviekuapp.data.model.network

import com.app.moviekuapp.data.model.entity.Credit
import com.google.gson.annotations.SerializedName

data class PersonCreditsResponse(
    @SerializedName("cast")
    override var results: List<Credit>
) : BaseListResponse<Credit>