package com.example.myjetpack1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun NotificationScreen(){
    var count: MutableState<Int> = rememberSaveable { mutableStateOf(0) } //todo.........rememberSaveable data store in bundle, not store in composable..............bundle save data only primitive type

    Column (

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)

    ){
        NotificationCounter(count.value ,{ count.value++ })
        MessageBar(count.value)
    }
}

@Composable
fun MessageBar(count: Int) {

    Card (

        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

        ){
        Row (
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = " ",
                Modifier.padding(4.dp)
            )

            Text(text = "Message sent so far - $count")
        }
    }
}

@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
    //var count: MutableState<Int> = rememberSaveable { mutableStateOf(0) } //todo.........rememberSaveable data store in bundle, not store in composable..............bundle save data only primitive type

    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "you  have sent ${count} notifications")
        Button(onClick = {
            increment()
            Log.d("TAGGGGGGGG","Button Clicked")
        }) {
            Text(text = "Send Notification")
        }

    }
}
