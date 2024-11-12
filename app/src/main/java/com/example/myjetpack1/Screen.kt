package com.example.myjetpack1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(heightDp = 500)
@Composable
fun PreviewItem(){
/*    BlogCategory(R.drawable.img,
        "Programming",
        "Learn new language")*/


/*    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().map { item ->
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle
            )
        }
    }*/


    LazyColumn(content ={
        items(getCategoryList()){item ->
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    } )
}



@Composable
fun BlogCategory(img:Int, title:String, subtitle:String){

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)) {


            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)

                )

        ItemDescription(title,subtitle, Modifier.weight(.8f) )

        }
    }


}

@Composable
fun ItemDescription(title: String,subtitle: String,modifier: Modifier){

    Column(modifier = modifier) {
        Text(
            text =title,
            style = MaterialTheme.typography.titleMedium
        )


        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Thin
        )

    }
}



data class Category(val img: Int,val title: String,val subtitle: String)


fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.img,"Programming","Learn different language"))
    list.add(Category(R.drawable.ic_acunit,"Technology","News about new teach"))
    list.add(Category(R.drawable.ic_addline,"Android Developer","Java or Kotlin"))
    list.add(Category(R.drawable.img,"Software Development","Learn something new "))
    list.add(Category(R.drawable.ic_acunit,"Technology","News about new teach"))
    list.add(Category(R.drawable.img,".Net","News about new teach"))
    list.add(Category(R.drawable.ic_acunit,"Ios","News about new teach"))
    list.add(Category(R.drawable.ic_addline,"Technology","News about new teach"))
    list.add(Category(R.drawable.ic_acunit,"Technology","News about new teach"))
    list.add(Category(R.drawable.ic_acunit,"Technology","News about new teach"))
    list.add(Category(R.drawable.img,"Programming","Learn different language"))
    list.add(Category(R.drawable.img,"Programming","Learn different language"))
    list.add(Category(R.drawable.img,"Programming","Learn different language"))

    return list
}