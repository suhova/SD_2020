package training.journal.controllers

import training.journal.navmenu.NavigationMenuListener

interface NavigationMenuController {

    fun openMenu()

    fun closeMenu()

    fun addMenuListener(listener: NavigationMenuListener)

    fun removeMenuListener(listener: NavigationMenuListener)
}