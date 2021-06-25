package com.example.bookapp.model

import java.io.Serializable

data class Book(
    val title: String,
    val description: String,
    val author: String,
    val imgUrl: String,
    val pages: Int,
    val review: Int,
    val rating: Float,
    val drawableResource: Int
) : Serializable
