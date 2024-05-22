package com.example.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage(){
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            Image(
                painter = painterResource(id = R.drawable.husky),
                contentDescription = "husky",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Text(text = "Siberian Husky")
            Text(text = "Germany")
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                ProfileStats(count = "15", title = "Followers")
                ProfileStats(count = "100", title = "Following")
                ProfileStats(count = "30", title = "Posts")

            }
            Button(onClick = { /*TODO*/ }) {
                
            }
            Button(onClick = { /*TODO*/ }) {
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}

@Composable
fun ProfileStats(count : String, title : String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)

    }
}

@Composable
fun Action(text : String, modifier: Modifier){
    Button(onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}

@Composable
fun ProfilePage1(){
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 30.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
    ){
        ConstraintLayout {
            val (image, nameText, locationText, profileStats, buttonFollow, buttonMessage) = createRefs()

            val guideLine = createGuidelineFromTop(0.1f)

            Image(painter = painterResource(id = R.drawable.husky),
                contentDescription = "husky",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                    .constrainAs(image) {
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            Text(text = "Siberian Husky",
                modifier = Modifier.constrainAs(nameText){
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Text(text = "Germany",
                modifier = Modifier.constrainAs(locationText){
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(profileStats) {
                        top.linkTo(locationText.bottom)
                    }
            ){
                ProfileStats(count = "150", title = "Followers")
                ProfileStats(count = "100", title = "Following")
                ProfileStats(count = "30", title = "Posts")
            }
            Button(onClick = {},
                modifier = Modifier.constrainAs(buttonFollow){
                    top.linkTo(profileStats.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(buttonMessage.start)
                    width = Dimension.wrapContent
                }
            ) {
                Text(text = "Follow user")
            }

            Button(onClick = {},
                modifier = Modifier.constrainAs(buttonMessage) {
                    top.linkTo(profileStats.bottom, margin = 16.dp)
                    start.linkTo(buttonFollow.end)
                    end.linkTo(parent.end)
            }){
                Text(text = "Direct message")
            }
        }
    }
}