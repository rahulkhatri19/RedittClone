package `in`.explorer.redittclone

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.explorer.redittclone.ui.theme.Gray20
import `in`.explorer.redittclone.ui.theme.Gray50
import `in`.explorer.redittclone.ui.theme.RedittCloneTheme


class HomePage: ComponentActivity() {
    val categoryList = arrayListOf<String>()
    val imageList = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            categoryList.add("All")
            categoryList.add("Technology")
            categoryList.add("Art")
            categoryList.add("Funny")
            categoryList.add("Nature")
            categoryList.add("Sports")
            imageList.add(R.drawable.img_1)
            imageList.add(R.drawable.img_2)
            imageList.add(R.drawable.img_3)
            imageList.add(R.drawable.img_4)
            imageList.add(R.drawable.img_5)
            imageList.add(R.drawable.img_6)
            RedittCloneTheme {
                // TODO: Try LazyColumn instead of column
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Gray20)) {
                    TopCategoryMethod(categoryList)
//                    items(categoryList) { item ->  Text(text = item)}
//                    Spacer(modifier = Modifier.height(1.dp))
                    LazyVerticalGrid(GridCells.Fixed(2), Modifier.padding(10.dp) ){
                        items(imageList.size){
                            Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(6.dp)) {
                                Column(
                                    Modifier
                                        .fillMaxSize()
                                        .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                    Image(painter = painterResource(id = imageList[it]), contentDescription = "Images")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun TopCategoryMethod(categoryList: ArrayList<String>) {
        Column(modifier = Modifier
            .padding(4.dp)){
            LazyRow(
                Modifier.padding(16.dp)
            ) {
                itemsIndexed(categoryList){ index, category ->
                    val boxColor = if (index == 0) Gray50 else Gray20
                        Box(modifier = Modifier
                            .clip(CircleShape)
                            .background(boxColor)
                            .padding(16.dp)) {
                            Text(
                                text = category,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                }

            }
        }
    }
}

@Preview(device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun homePagePreview(){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray20)) {

    }
}