package com.example.medcords.model

data class ApiResponse(
    val `data`: Data,
    val errCode: Int,
    val msg: String,
    val status: Int
)