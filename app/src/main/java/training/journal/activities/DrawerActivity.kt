package training.journal.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.mikepenz.iconics.typeface.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import training.journal.R

abstract class DrawerActivity : AppbarActivity() {

    companion object {
        const val SEARCH_ITEM_ID = 1
        const val BOOKMARKS_ITEM_ID = 2
        const val FAVOURITE_ITEM_ID = 3
        const val SETTINGS_ITEM_ID = 4
    }

    private val menuItemsArray = arrayOf(
            PrimaryDrawerItem()
                    .withName(R.string.drawer_item_search)
                    .withIcon(R.drawable.ic_search)
                    .withIdentifier(SEARCH_ITEM_ID),
            PrimaryDrawerItem().withName(R.string.drawer_item_bookmarks)
                    .withIcon(R.drawable.ic_bookmarks)
                    .withIdentifier(BOOKMARKS_ITEM_ID),
            PrimaryDrawerItem()
                    .withName(R.string.drawer_item_favourites)
                    .withIcon(FontAwesome.Icon.faw_star_half_empty)
                    .withIdentifier(FAVOURITE_ITEM_ID),
            DividerDrawerItem(),
            SecondaryDrawerItem()
                    .withName(R.string.drawer_item_settings)
                    .withIcon(R.drawable.ic_settings)
                    .withIdentifier(SETTINGS_ITEM_ID)
    )

    private var navMenu: Drawer.Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navMenu = Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header_nav_menu)
                .withOnDrawerListener(object : Drawer.OnDrawerListener {
                    override fun onDrawerOpened(drawerView: View?) {
                        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                    }

                    override fun onDrawerClosed(drawerView: View?) {
                        // do nothing
                    }
                })
                .addDrawerItems(*menuItemsArray)
                .build()
        navMenu?.setOnDrawerItemClickListener { _, _, _, _, drawerItem ->
            when (drawerItem.identifier) {
                SEARCH_ITEM_ID -> {}
                BOOKMARKS_ITEM_ID -> {}
                FAVOURITE_ITEM_ID -> {}
                SETTINGS_ITEM_ID -> router?.showSettingsPage()
            }
        }
    }

    override fun onBackPressed() {
        if (navMenu?.isDrawerOpen == true) {
            navMenu?.closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    override fun hasNavigationMenu() = true
}