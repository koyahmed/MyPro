package com.example.simplemessenger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(
    private val messages: MutableList<Message>
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageText: TextView = view.findViewById(R.id.messageText)
        val timestampText: TextView = view.findViewById(R.id.timestampText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.messageText.text = message.text
        holder.timestampText.text = message.timestamp

        val bubbleColor = if (message.isFromUser) {
            R.color.user_message
        } else {
            R.color.contact_message
        }
        holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, bubbleColor))

        val params = holder.itemView.layoutParams as RecyclerView.LayoutParams
        if (message.isFromUser) {
            params.marginStart = 80
            params.marginEnd = 0
        } else {
            params.marginStart = 0
            params.marginEnd = 80
        }
        holder.itemView.layoutParams = params
    }

    override fun getItemCount(): Int = messages.size

    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }
}
