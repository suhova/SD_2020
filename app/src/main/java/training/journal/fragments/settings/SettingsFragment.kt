package training.journal.fragments.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import training.journal.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.fragment_settings)
    }
}