package `in`.explorer.redittclone

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.explorer.redittclone.ui.theme.Gray20
import `in`.explorer.redittclone.ui.theme.Gray50
import `in`.explorer.redittclone.ui.theme.RedittCloneTheme


class HomePage: ComponentActivity() {
    val categoryList = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            categoryList.add("All")
            categoryList.add("Technology")
            categoryList.add("Art")
            categoryList.add("Funny")
            categoryList.add("Nature")
            categoryList.add("Sports")
            RedittCloneTheme {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Gray20)) {
                    TopCategoryMethod(categoryList)
                }
            }
        }
    }

    @Composable
    private fun TopCategoryMethod(categoryList: ArrayList<String>) {
        Column(modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()){
            LazyRow(
                Modifier.padding(16.dp)
            ) {
                itemsIndexed(categoryList){ index, category ->
                    val boxColor = if (index == 0) Gray50 else Gray20
                        Box(modifier = Modifier
                            .clip(CircleShape)
                            .background(boxColor).padding(16.dp)) {
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