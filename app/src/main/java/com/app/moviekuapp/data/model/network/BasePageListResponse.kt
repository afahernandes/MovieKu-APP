package com.app.moviekuapp.data.model.network

interface BasePageListResponse<T> {
    var page: Int
    var results: List<T>
}