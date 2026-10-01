package br.edu.ifsp.scl.prdm.sc3011879.persistentContactList

import androidx.lifecycle.ViewModel
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.model.Contact
import br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactViewModel: ViewModel() {
    private val _currentContact = MutableStateFlow(Contact())
    val currentContact: StateFlow<Contact> = _currentContact.asStateFlow()

    private val _contactList: MutableStateFlow<List<Contact>> = MutableStateFlow(emptyList())
    val contactlist: StateFlow<List<Contact>> = _contactList.asStateFlow()
}