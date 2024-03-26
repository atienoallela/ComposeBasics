package com.example.recaponcomposeui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recaponcomposeui.ui.theme.RecapOnComposeUITheme

class Wawili : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecapOnComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartPotrait()
                }
            }
        }
    }
}
@Composable
fun CartCount(modifier : Modifier = Modifier){
    Column(modifier = modifier.padding(20.dp)) {
        var count by remember {
            mutableStateOf(0)
        }
        Text(
            text = "You have added $count items to cart" ,
            modifier = modifier.padding(20.dp)
        )
        Row {
        Button(onClick = { count++ } , Modifier.padding(10.dp)) {
            Icon(
                imageVector = Icons.Default.Add ,
                contentDescription = null)
        }
        Button(onClick = { count-- } , Modifier.padding(10.dp)) {
            Icon(imageVector = Icons.Default.Delete , contentDescription = null)
        }
        }
    }
}
@Composable
fun CartScreen(modifier : Modifier = Modifier){
    Column(modifier.verticalScroll(rememberScrollState())){
        Spacer(Modifier.padding(horizontal = 20.dp))
        CartCount()
    }
}
@Composable
fun CartNav(modifier : Modifier = Modifier) {
    val context = LocalContext.current
NavigationBar(modifier = modifier,
    containerColor = MaterialTheme.colorScheme.surfaceVariant
) {
    NavigationBarItem(
        selected = false
        , onClick = {
                    context.startActivity(Intent(context,MainActivity::class.java))
        },
        label = {
                Text(text = "Home")
        },
        icon = {
            Icon(imageVector = Icons.Default.Home , contentDescription =null )
        })
    NavigationBarItem(selected = false ,
        onClick = { /*TODO*/ } ,
        label = {
                Text(stringResource(id = R.string.favorites))
        },
        icon = { 
            Icon(
                imageVector = Icons.Default.Favorite ,
                contentDescription = null)
        })
    NavigationBarItem(
        selected = true ,
        onClick = { /*TODO*/ } ,
        label = {
                Text(text = "Cart")
        },
        icon = {
            Icon(
                imageVector =  Icons.Default.ShoppingCart,
                contentDescription = null)
        })
}

}

@Composable
fun CartPotrait(){
    RecapOnComposeUITheme {
        Scaffold (bottomBar = { CartNav()}){
            padding -> CartScreen(Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    RecapOnComposeUITheme {
        CartPotrait()
    }
}