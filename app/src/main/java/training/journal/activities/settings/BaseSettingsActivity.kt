package training.journal.activities.settings

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceFragmentCompat
import kotlinx.android.synthetic.main.view_appbar.*
import training.journal.R
import training.journal.activities.AppbarActivity

abstract class BaseSettingsActivity : AppbarActivity() {

    companion object {
        const val EMPTY_KEY = "KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSettingsFragment()
    }

    private fun setSettingsFragment() {
        supportFragmentManager.beginTransaction().add(R.id.main_container, getPreferencesFragment()).commit()
        supportFragmentManager.executePendingTransactions()
    }

    override fun getToolbarView(): Toolbar = base_toolbar

    override fun getActivityLayoutId(): Int = R.layout.activity_base_fragment

    abstract fun getPreferencesFragment(): PreferenceFragmentCompat
}
