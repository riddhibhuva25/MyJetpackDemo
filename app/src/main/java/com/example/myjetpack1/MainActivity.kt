package com.example.myjetpack1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpack1.quot_screens.DataManager
import com.example.myjetpack1.quot_screens.QuotDetailScreen
import com.example.myjetpack1.quot_screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.text.Typography.quote
//import com.example.myjetpack1.quot_screens.QuotDetailScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            // delay(10000)
            DataManager.loadAssetsFromFile(applicationContext)//todo..........for quote screen........

        }

        setContent {
            //Text(text = "Hello Android")
            //TextInputField()
            //PrevModifier()
            //PreviewItem()//Screen.kt fun
            //NotificationScreen()

            App()
 }
    }
}




@Composable
fun App(){ //todo......... for quote screen


    if (DataManager.isDataLoaded.value){


        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)

            }
        }
        else{
            //QuotDetailScreen(quote =DataManager.currentQuote)
            DataManager.currentQuote?.let { QuotDetailScreen(quote = it) }

        }
    }
    else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ){
            Text(text = "Loading.....",
                style = MaterialTheme.typography.bodySmall)
        }
    }

}

enum class Pages{  //todo......... for quote screen
    LISTING,
    DETAIL

}
//@Preview(showBackground = true, showSystemUi = true)
//@Preview(showBackground = true)
@Composable
fun Data(name: String = "Android1"){
    Text(text = "Hello $name")
}


//@Preview(showBackground = true, showSystemUi = true, widthDp = 200, heightDp = 200)
//@Preview(showBackground = true)
@Composable
private fun PreviewFun(){ //todo..............for Textview.....................
    //Data(name = "Compose")
    Text(text = "Hello world",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        fontSize = 24.sp


        )
}

//@Preview(showBackground = true)
@Composable
private fun ImageFun(){  //todo...............for imageview.........................
    Image(painter = painterResource(R.drawable.img),
        contentDescription = "Dummy Image",)
        //colorFilter = ColorFilter.tint(Color.Blue))

}

//@Preview(showBackground = true)
@Composable
private fun ButtonFun(){
    Button(onClick = { }, colors = ButtonDefaults.buttonColors(
        contentColor = Color.Red,
       // backgroundColor = Color.Blue

    ), enabled = false
    ) {
        Text(text = "Hello")

        Image(painter = painterResource(R.drawable.img),
            contentDescription = "Dummy")
    }
}

//@Preview(showBackground = true)
@Composable
private fun TextInput(){
    TextField(value = "Hello Kotlin",
        onValueChange = {},
        label =  { Text(text = "Enter message") },
        placeholder ={} )
}

@Composable
fun TextInputField(){
    val state = remember { mutableStateOf(" ") }
    TextField(
        value = state.value,
        onValueChange = {

           // Log.d("My Java",it)
            state.value = it
        },
        label =  { Text(text = "Enter message") }
    )
}

///@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
private fun PrevLayout(){ //todo.............recyclerview ..........


    /*Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {//for vertically set like linear layout
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }*/



    /*Row (
    horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)

    }*/



    /*Box (
    contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(R.drawable.ic_acunit), contentDescription = "")
        Image(painter = painterResource(R.drawable.ic_addline), contentDescription = "")
    }*/

    Column {
        ListViewItem(R.drawable.img,"John Doe","Software Developer")
        ListViewItem(R.drawable.ic_addline,"Devid","Android Developer")
        ListViewItem(R.drawable.img,"Mark","Ios Developer")
        ListViewItem(R.drawable.ic_acunit,"Jessica","SpringBoot Developer")
        ListViewItem(R.drawable.img,"Lisa","Hardware Developer")

    }

}
//@Preview(showBackground = true)
@Composable
fun ListViewItem(imgId:Int, name: String, occupation:String){ //todo...........recyclerview.........//also we can add modifier as parameter and use that modifier
    Row(Modifier.padding(8.dp)) {
        Image(painter = painterResource(imgId),
            contentDescription = "",
            Modifier.size(40.dp))
        Column() {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = occupation, fontWeight = FontWeight.Thin,
                fontSize = 12.sp)
        }
    }

}


@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
private fun PrevModifier(){ //todo............modifier example..........
    Text(text = "Hello",
        color = Color.White,
        modifier = Modifier.clickable {  }
            .background(Color.Blue)
            .size(200.dp)
            .padding(36.dp)
            .border(4.dp, Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow)



        )
}

@Composable
fun CircularImage(){ //todo........ for any image show in circle shape 
    Image(painter = painterResource(R.drawable.img),
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(80.dp)
            .clip(CircleShape)
            .border(2.dp, color = Color.LightGray, CircleShape),

        contentDescription = "")
}

@Composable
fun ReComposable(){ //todo......................ReComposition example...........
    val state = remember { mutableListOf(0.0) }
    Log.d("TAGGED","Logged during Initial Composition")
    Button(onClick = {
       // state.value = Math.random()
    }) {
        Log.d("TAGGED","Logged during both Composition and ReComposition")
        //Text(text = state.value.toString)
    }

}



