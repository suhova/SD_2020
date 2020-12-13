package training.journal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class LoginScreen {

    fun getMainLabel(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.login_title_tv))
    }

    fun getErrorView(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.md_root))
    }

    fun typeLogin(login: String): LoginScreen {
        Espresso.onView(ViewMatchers.withId(R.id.email_et))
                .perform(
                        ViewActions.typeText(login),
                        ViewActions.closeSoftKeyboard()
                )
        return this
    }

    fun typePassword(password: String): LoginScreen {
        Espresso.onView(ViewMatchers.withId(R.id.password_et))
                .perform(
                        ViewActions.typeText(password),
                        ViewActions.closeSoftKeyboard()
                )
        return this
    }

    fun pressConfirmButton(): MainMenuScreen {
        Espresso.onView(ViewMatchers.withId(R.id.confirm_button))
                .perform(ViewActions.click())
        return MainMenuScreen()
    }

    fun pressNotExistAccountButton(): RegistrationScreen {
        Espresso.onView(ViewMatchers.withId(R.id.not_exist_acc_tv))
                .perform(ViewActions.click())
        return RegistrationScreen()
    }
}
