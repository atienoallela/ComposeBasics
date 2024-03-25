package com.example.recaponcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recaponcomposeui.ui.theme.RecapOnComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecapOnComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   LandingPageScreen()
                }
            }
        }
    }
}

@Composable
fun searchit(modifier: Modifier = Modifier) {
    Row {

        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface

            ),
            placeholder = {
                Text(text = "Search")
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 50.dp)
        )
    }
}
@Composable
fun profiles(@DrawableRes drawable:Int,
             @StringRes text:Int,
             modifier: Modifier = Modifier){
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(drawable) ,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
    
}
    @Composable
    fun profilerow(modifier: Modifier = Modifier){
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
            modifier = modifier) {
            items(profiledata){
                item -> profiles(item.drawable,item.text)
            }
        }
    }

private val profiledata = listOf(
    R.drawable.dee to R.string.dee,
    R.drawable._58f20b6_6455_4d17_9658_16f139994e5b_1_201_a to R.string.name,
    R.drawable.a to R.string.da,
    R.drawable.allela to R.string.ma,
    R.drawable.allelaclass to R.string.dod,
).map { DrawableStringPair(it.first,it.second) }

private class DrawableStringPair(@DrawableRes val drawable:Int,
                                 @StringRes val text:Int) {
}
@Composable
fun Moments(@DrawableRes drawable: Int,@StringRes text: Int,modifier: Modifier = Modifier){
    Surface(shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(240.dp)) {
            Image(
                painter = painterResource(drawable) ,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(text = stringResource(text) ,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 20.dp))
        }
    }
}
@Composable
fun MomentsGrids(modifier: Modifier = Modifier){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier.height(180.dp)
    ) {
        items(momentsdata){
            item -> Moments(item.drawable, item.text)
        }
    }
}
private val momentsdata = listOf(
    R.drawable.dee to R.string.dee,
    R.drawable._58f20b6_6455_4d17_9658_16f139994e5b_1_201_a to R.string.name,
    R.drawable.a to R.string.da,
    R.drawable.allela to R.string.ma,
    R.drawable.allelaclass to R.string.dod,
).map { DrawableStringPair(it.first,it.second) }

@Composable
fun HomePage(@StringRes title: Int,modifier: Modifier = Modifier,content:@Composable () -> Unit){
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
        )
        content()
    }
}
@Composable
fun LandingPageScreen(modifier: Modifier = Modifier){
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(20.dp))
        searchit(Modifier.padding(horizontal = 20.dp))
        HomePage(title = R.string.deee) {
            profilerow()
        }
        HomePage(title = R.string.daaaaaa) {
            MomentsGrids()
        }
        Spacer(Modifier.height(20.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    RecapOnComposeUITheme {
        searchit()
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecapOnComposeUITheme {
        LandingPageScreen()
    }
}