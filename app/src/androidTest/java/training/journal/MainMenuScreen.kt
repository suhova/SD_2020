package training.journal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.core.IsNot.not

class MainMenuScreen {
    private val addWorkoutId = R.id.add_workout_button

    fun createWorkout(name: String): MainMenuScreen{
        return pressAddWorkoutButton()
                .enterWorkoutName(name)
                .pressSaveButton()
    }
    fun createWorkoutWithoutDays(name: String): MainMenuScreen{
         pressAddWorkoutButton()
                .enterWorkoutName(name)
                .uncheckAllDays()
                .pressSaveButton()
        return this
    }

    fun checkWorkoutLabel(name: String): ViewInteraction {
        return this.getWorkoutLabel(name)
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun pressAddWorkoutButton(): CreateWorkoutScreen {
        Espresso.onView(ViewMatchers.withId(addWorkoutId)).perform(ViewActions.click())
        return CreateWorkoutScreen()
    }
    fun getWorkoutLabel(name: String): ViewInteraction {
        return Espresso.onView(ViewMatchers.withText(name))
    }

    fun isCreateWorkoutScreen(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.apply_changes))
                .check(ViewAssertions.matches(isDisplayed()))
    }
}