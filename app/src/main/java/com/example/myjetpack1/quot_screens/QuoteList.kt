package com.example.myjetpack1.quot_screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.myjetpack1.quot_screens.model.Quote


@Composable
fun QuoteList(data :Array<Quote>, onClick : (quote:Quote)->Unit){

    LazyColumn (content = {

        items(data){
            QuotListItem(quote = it, onClick)
        }

    })

}