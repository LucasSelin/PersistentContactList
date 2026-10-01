package br.edu.ifsp.scl.prdm.sc3011879.persistentContactList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.navigation.MainNavHost
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.navigation.Screen
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.ui.composable.component.MainTopAppBar
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.ui.theme.PersistentContactListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            val contactViewModel: ContactViewModel = viewModel()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val action = navBackStackEntry?.destination?.route == Screen.List

            PersistentContactListTheme {
                Scaffold(
                    topBar = {
                        MainTopAppBar(showActions = action) {
                            navHostController.navigate(Screen.Contact.route)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersistentContactListTheme {
        Greeting("Android")
    }
}