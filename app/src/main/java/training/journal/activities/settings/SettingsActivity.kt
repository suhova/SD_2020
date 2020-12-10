package training.journal.activities.settings

import androidx.preference.PreferenceFragmentCompat
import training.journal.R
import training.journal.fragments.settings.SettingsFragment

class SettingsActivity : BaseSettingsActivity() {

    override fun getToolbarTitle(): String = getString(R.string.settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = SettingsFragment()
}
