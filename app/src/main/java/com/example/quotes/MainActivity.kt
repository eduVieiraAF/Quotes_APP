package com.example.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RequestManager(this@MainActivity).getAllQuotes(listener)
    }

    private val listener: QuotesResponseListener = object : QuotesResponseListener{

        override fun didFetch(response: List<QuotesResponse>, message: String) {

            RV_quotes.setHasFixedSize(true)
            RV_quotes.layoutManager = StaggeredGridLayoutManager(2,
                LinearLayoutManager.VERTICAL)
            val adapter = QuotesListAdapter(this@MainActivity, response)
            RV_quotes.adapter = adapter
        }

        override fun didError(message: String) {

            AlertDialog.Builder(this@MainActivity)
                .setTitle("ERROR")
                .setMessage(message)
                .setPositiveButton("Okay"){_,_ ->}
                .show()
        }
    }
    // TODO: work on the "copy" button
}
