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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import java.nio.file.WatchEvent

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
    //variable to maintain the like and unlike statements
    var isLiked= remember {mutableStateOf(false) }
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
        // instagram image
        // box composable :: Box like container
        Box (modifier = Modifier.fillMaxWidth().height(300.dp)) {
            Image(painter = painterResource(id = R.drawable.tino9),
                contentDescription = "post image",
            modifier = Modifier.fillMaxSize(),
              contentScale = ContentScale.Crop  )

        }
        //action button
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp)){
            // IconButton :like button
            IconButton(onClick = {isLiked.value=!isLiked.value}) {
                Icon(
                    if (isLiked.value) Icons.Filled.Favorite
                    else Icons.Outlined.FavoriteBorder,
                    contentDescription="like Button",
                    tint = if (isLiked.value) Color.Red
                    else MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.CheckCircle, contentDescription = "comment")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Share, contentDescription = "share")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Star, contentDescription = "save")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Send, contentDescription = "sent")
            }

            }
        Text(text = "${if (isLiked.value)1 else 0} likes",
            fontWeight= FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 4.dp))
        Row (modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
            Text(text = "Username", fontWeight= FontWeight.Bold)
            Text(text = "This is a sample instagram caption!")
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




