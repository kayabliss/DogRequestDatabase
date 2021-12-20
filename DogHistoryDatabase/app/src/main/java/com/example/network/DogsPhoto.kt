package com.example.network

import com.squareup.moshi.Json

data class DogsPhoto(
@Json(name ="message")
val url: String?,

@Json(name = "status")
var status: String?,
)