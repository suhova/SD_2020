package training.journal.activities.settings

import android.os.Bundle
import training.journal.R
import training.journal.activities.BaseFragmentActivity

class AccountSettingsActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router?.showAccountSettingsSubPage()
    }

    override fun getToolbarTitle(): String = getString(R.string.account_settings)

    override fun canOpenNavMenuFromToolbar(): Boolean = false
}