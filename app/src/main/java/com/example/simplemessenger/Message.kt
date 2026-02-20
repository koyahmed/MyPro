package com.example.simplemessenger

data class Message(
    val text: String,
    val isFromUser: Boolean,
    val timestamp: String
)
