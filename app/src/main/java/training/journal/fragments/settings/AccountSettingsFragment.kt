package training.journal.fragments.settings

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import training.journal.R
import training.journal.activities.settings.BaseSettingsActivity
import training.journal.utils.toast.ToastUtils
import training.journal.utils.validator.UserValidator

class AccountSettingsFragment : PreferenceFragmentCompat(), Preference.OnPreferenceChangeListener {

    private var sharedPrefs: SharedPreferences? = null

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.fragment_account_settings)
        sharedPrefs = preferenceScreen.sharedPreferences
        initPreferences()
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        return if (preference is EditTextPreference) {
            when (preference.key) {
                context?.getString(R.string.last_name_settings_key),
                context?.getString(R.string.first_name_settings_key),
                context?.getString(R.string.father_name_settings_key) -> {
                    return if (UserValidator.validName(newValue as? String)) true
                    else {
                        context?.let { ToastUtils.showErrorToast(it) }
                        false
                    }
                }
                else -> false
            }
        } else true
    }

    // todo later set value from user repository
    private fun initPreferences() {
        val lastNamePrefs = findPreference(context?.getString(R.string.last_name_settings_key)
                ?: BaseSettingsActivity.EMPTY_KEY) as EditTextPreference?
        setSummary(lastNamePrefs)

        val firstNamePrefs = findPreference(context?.getString(R.string.first_name_settings_key)
                ?: BaseSettingsActivity.EMPTY_KEY) as EditTextPreference?
        setSummary(firstNamePrefs)

        val fatherNamePrefs = findPreference(context?.getString(R.string.father_name_settings_key)
                ?: BaseSettingsActivity.EMPTY_KEY) as EditTextPreference?
        setSummary(fatherNamePrefs)
    }

    private fun setSummary(pref: Preference?) {
        pref?.summary = sharedPrefs?.getString(pref?.key, null)
    }
}