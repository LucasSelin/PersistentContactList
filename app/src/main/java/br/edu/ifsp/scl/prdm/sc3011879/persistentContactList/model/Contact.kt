package br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val id: Int = INVALID_CONTACT_ID,
    val name: String = "",
    val address: String = "",
    val email: String = "",
    val phone: String = "",
): Parcelable{
    companion object {
        const val INVALID_CONTACT_ID = -1
    }
}
