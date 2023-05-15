package `in`.explorer.redittclone

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.explorer.redittclone.ui.theme.RedittCloneTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedittCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp), verticalArrangement = Arrangement.SpaceBetween) {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)) {
                            Image(painterResource(id = R.drawable.reddit_logo),"Logo", modifier = Modifier
                                .align(
                                    TopCenter
                                )
                                .size(50.dp, 50.dp))
                            Text(text = "Skip", modifier = Modifier.align(Alignment.CenterEnd))
                        }


                        Text (text = "Dive into anything",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp, bottom = 40.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp, fontWeight = FontWeight.Bold,
                        )
                        Image(painter = painterResource(id = R.drawable.themes_icon), contentDescription = "Login main image", modifier = Modifier
                            .size(500.dp, 200.dp)
                            .padding(bottom = 10.dp))
                        Column() {
                            LoginButtons(modifier = Modifier.fillMaxWidth(), text = stringResource(id = R.string.continue_with_google)) {
                                Toast.makeText(this@LoginActivity, "User clicking on button", Toast.LENGTH_SHORT).show()
                            }
                            LoginButtons(modifier = Modifier.fillMaxSize(), text = "Continue with Apple") {
                                Toast.makeText(this@LoginActivity, "User clicking on button", Toast.LENGTH_SHORT).show()
                            }
                            LoginButtons(modifier = Modifier.fillMaxSize(), text = "Continue with email") {
                                Toast.makeText(this@LoginActivity, "User clicking on button", Toast.LENGTH_SHORT).show()
                            }
                        }
                        Text(text = "By continuing, you agree to our User Agreement and acknowledge that you understand the Privacy Policy", fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                            Checkbox(checked = false, onCheckedChange = {
                                Toast.makeText(this@LoginActivity, "User trying to check", Toast.LENGTH_SHORT).show()
                            })
                            Text(text = "I agree to receive email about cool stuff on Reddit", fontSize = 10.sp)
                        }
                        Text(text = "Already a redditor? Log in", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}


@Preview(device = Devices.PIXEL_4, uiMode = UI_MODE_TYPE_NORMAL)
@Composable
fun GreetingPreview() {
    RedittCloneTheme {
        LoginButtons(modifier = Modifier, "Hello Shijen", ) {
            Log.d("Shijen", "GreetingPreview: Clicking on button")
        }
    }
}

@Composable
fun LoginButtons( modifier: Modifier, text:String, onClick:()->Unit){
    Box (modifier = Modifier
        .height(60.dp)
        .padding(5.dp)
        .clipToBounds()
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(25.dp))
        .background(colorResource(R.color.login_button_grey))
        .clickable { onClick.invoke() }
        ) {
        Image (painter = painterResource(id = R.drawable.google),
            contentDescription = "Google Icon",
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .padding(start = 10.dp)
                .align(CenterStart))
        Text(text = text, fontSize = 14.sp, modifier = Modifier.align(
            Center), color = Color.Black )
    }

}