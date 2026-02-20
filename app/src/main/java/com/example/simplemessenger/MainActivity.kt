package com.example.simplemessenger

import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messages = mutableListOf(
            Message("Hey! This is a simple messaging demo.", false, currentTime()),
            Message("Type a message and tap send.", false, currentTime())
        )

        messageAdapter = MessageAdapter(messages)

        val recyclerView = findViewById<RecyclerView>(R.id.messagesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = messageAdapter

        val inputField = findViewById<EditText>(R.id.messageInput)
        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val text = inputField.text.toString().trim()
            if (text.isNotEmpty()) {
                messageAdapter.addMessage(Message(text, true, currentTime()))
                recyclerView.scrollToPosition(messageAdapter.itemCount - 1)
                inputField.text.clear()

                recyclerView.postDelayed({
                    messageAdapter.addMessage(Message("Auto-reply: $text", false, currentTime()))
                    recyclerView.scrollToPosition(messageAdapter.itemCount - 1)
                }, 500)
            }
        }
    }

    private fun currentTime(): String = DateFormat.format("hh:mm a", Date()).toString()
}
