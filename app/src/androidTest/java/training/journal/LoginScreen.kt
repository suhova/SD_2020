package training.journal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class LoginScreen {
    private val loginTitleId = R.id.login_title_tv
    private val emailId = R.id.email_et
    private val passwordId = R.id.password_et
    private val confirmId = R.id.confirm_button

    fun login(): MainMenuScreen {
        return typeLogin("login")
                .typePassword("pass")
                .pressConfirmButton()
    }

    fun getMainLabel(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(loginTitleId))
    }

    fun typeLogin(login: String): LoginScreen {
        Espresso.onView(ViewMatchers.withId(emailId))
                .perform(
                        ViewActions.typeText(login),
                        ViewActions.closeSoftKeyboard()
                )
        return this
    }

    fun typePassword(password: String): LoginScreen {
        Espresso.onView(ViewMatchers.withId(passwordId))
                .perform(
                        ViewActions.typeText(password),
                        ViewActions.closeSoftKeyboard()
                )
        return this
    }

    fun pressConfirmButton(): MainMenuScreen {
        Espresso.onView(ViewMatchers.withId(confirmId))
                .perform(ViewActions.click())
        return MainMenuScreen()
    }
}
