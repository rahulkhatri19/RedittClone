package `in`.explorer.redittclone

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Discover : BottomNavItem("Discover", R.drawable.ic_discover, "discover")
    object Create : BottomNavItem("Create", R.drawable.ic_create, "create")
    object Chat : BottomNavItem("Chat", R.drawable.ic_chat, "chat")
    object Inbox : BottomNavItem("Inbox", R.drawable.ic_inbox, "inbox")
}
