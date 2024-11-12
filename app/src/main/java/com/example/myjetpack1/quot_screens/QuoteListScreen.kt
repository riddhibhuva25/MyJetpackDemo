package com.example.myjetpack1.quot_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myjetpack1.R
import com.example.myjetpack1.quot_screens.model.Quote

@Composable
fun QuoteListScreen(data : Array<Quote>, onClick : (quote:Quote)->Unit){
    Column (){
        Text(text = "Quote App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp,24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.bodySmall,
            fontFamily = FontFamily(Font(R.font.sf_regular))
        )
        QuoteList(data = data,onClick)
    }
}