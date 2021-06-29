package com.app.moviekuapp.data.model.network

interface BaseListResponse<T> {
    var results: List<T>
}
