package com.example.quotes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesListAdapter(private val context: Context, private val list: List<QuotesResponse>,

    private val listener: CopyListener) : RecyclerView.Adapter<QuotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {

       val layout = LayoutInflater.from(context).inflate(R.layout.list_quotes,
           parent, false)

        return QuotesViewHolder(layout)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {

        holder.quote.text = "'${list[position].text}'"
        holder.author.text = "-${list[position].author ?: "Unknown"}"
        holder.copy.setOnClickListener {listener.onCopyClicked(list[holder.adapterPosition].text)}
    }

    override fun getItemCount(): Int {

        return list.size
    }
}

class QuotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var quote: TextView = itemView.findViewById(R.id.TV_quote)
    var author: TextView = itemView.findViewById(R.id.TV_author)
    var copy: Button = itemView.findViewById(R.id.BTN_copy)
}