package br.edu.ifsp.scl.prdm.sc3011879.persistentContactList.navigation

sealed class Screen(val route: String) {
    data object list: Screen("list_screen")
    data object Contact: Screen("contact_screen")
    companion object {
        val List: Any
    }
}