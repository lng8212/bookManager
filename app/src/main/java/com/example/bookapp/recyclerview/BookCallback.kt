package com.example.bookapp.recyclerview

import com.example.bookapp.model.Book

interface BookCallback {

    fun sendData(a : Book)
}