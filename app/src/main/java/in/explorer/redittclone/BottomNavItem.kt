package `in`.explorer.redittclone

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", android.R.drawable.ic_menu_agenda,"home")
    object Discover: BottomNavItem("Discover", android.R.drawable.ic_menu_slideshow,"discover")
    object Create: BottomNavItem("Create",android.R.drawable.ic_menu_add,"create")
    object Chat: BottomNavItem("Chat", android.R.drawable.ic_menu_agenda,"chat")
    object Inbox: BottomNavItem("Inbox", android.R.drawable.ic_menu_slideshow,"inbox")
}
