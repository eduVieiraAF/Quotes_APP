package com.example.quotes

interface QuotesResponseListener {

    fun didFetch(response: List<QuotesResponse>, message: String)
    fun didError(message: String)
}