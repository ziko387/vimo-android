package com.example.vimoapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import com.example.vimoapp.ui.theme.PurpleGrey40
import androidx.compose.ui.layout.ContentScale
import android.R.attr.fontWeight
import android.view.Surface
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

// this process creates a new activity i.e. an independent android screen
// on class creation extend componentactivity open class  with empty constructor
class ConstraitActivityLayout : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //we load on our composable
        // we need to  confirm the indication of the constrain layout
        setContent{
            MaterialTheme {
                // ready composable frame from android design
                //modifier is  an attribute for composable that allows
                Surface(modifier =Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    //host other items button, images,text
                }
                }
            }
        }
    }


        //clone instagram posts to be shown
        // users profile
       //users profile + username : at the top
      // image post
     // buttons for like , comment and share
    // a caption
  // timestamp




@Composable
fun  InstagramPostCard() {
    //create a card element
    Card(shape = RoundedCornerShape(12.dp),
    elevation= CardDefaults.cardElevation(defaultElevation = 6.dp),
     modifier = Modifier.fillMaxWidth().padding(16.dp)){
    Column {
        Row (verticalAlignment = Alignment.CenterVertically,
        modifier= Modifier.fillMaxWidth().padding(8.dp)){
           Image(painter = painterResource(id = R.drawable.tino4),
               contentDescription = "profile picture",
               modifier = Modifier.size(40.dp).clip(CircleShape)
                   .border(1.dp,Color.Gray, CircleShape),
               contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "username", fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f))


        }
    }



    }



    }

@Preview(showBackground = true)
@Composable
fun InstagramPostCardPreview(){
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background){
            InstagramPostCard()
        }
    }
}




