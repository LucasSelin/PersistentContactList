package br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.ContactViewModel
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.ui.composable.screen.ContactScreen
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.ui.composable.screen.ListScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    contactViewModel: ContactViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.list.route,
        modifier = modifier
    ) {
        composable(route = Screen.list.route) {
            ListRoute(contactViewModel)
        }
        composable(route = Screen.Contact.route) {
            ContactRoute(contactViewModel) { navHostController.popBackStack() }
        }
    }
}

@Composable
fun ListRoute(contactViewModel: ContactViewModel, modifier: Modifier = Modifier) {
    val contactList by contactViewModel.contactlist.collectAsStateWithLifecycle()
    ListScreen(contactList = contactList, modifier = modifier)
}

@Composable
fun ContactRoute(contactViewModel: ContactViewModel, modifier: Modifier = Modifier, onDone: () -> Unit) {
    val contact by contactViewModel.currentContact.collectAsStateWithLifecycle()
    ContactScreen(contact = contact, modifier = modifier) {
        onDone()
    }
}