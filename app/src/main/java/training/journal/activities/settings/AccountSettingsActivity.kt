package training.journal.activities.settings

import androidx.preference.PreferenceFragmentCompat
import training.journal.R
import training.journal.fragments.settings.AccountSettingsFragment

class AccountSettingsActivity : BaseSettingsActivity() {

    override fun getToolbarTitle(): String = getString(R.string.account_settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = AccountSettingsFragment()
}