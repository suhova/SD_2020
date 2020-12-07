package training.journal.activities

import androidx.fragment.app.Fragment
import training.journal.fragments.LoginFragment

class LoginActivity : BaseNoAppbarActivity() {

    override fun getSupportingFragment(): Fragment = LoginFragment()

    override fun hasNavigationMenu(): Boolean = false
}
