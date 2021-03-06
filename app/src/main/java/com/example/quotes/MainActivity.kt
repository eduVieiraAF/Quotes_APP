package com.example.quotes

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), QuotesResponseListener, CopyListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RequestManager(this).getAllQuotes(this)
    }

    override fun didFetch(response: List<QuotesResponse>, message: String) {

        RV_quotes.setHasFixedSize(true)
        RV_quotes.layoutManager = StaggeredGridLayoutManager(
            2,
            LinearLayoutManager.VERTICAL
        )
        val adapter = QuotesListAdapter(this@MainActivity, response, this)
        RV_quotes.adapter = adapter
    }

    override fun didError(message: String) {

        AlertDialog.Builder(this@MainActivity)
            .setTitle("ERROR")
            .setMessage(message)
            .setPositiveButton("Okay") { _, _ -> }
            .show()
    }


        override fun onCopyClicked(text: String) {

            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copied_data", text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(
                this@MainActivity, "Quote copied to clipboard",
                Toast.LENGTH_LONG
            ).show()

    }
}
