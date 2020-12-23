package training.journal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import okhttp3.internal.immutableListOf

class CreateWorkoutScreen {

    private val lst = immutableListOf(R.id.day1, R.id.day2, R.id.day3, R.id.day4, R.id.day5, R.id.day6, R.id.day7)
    private val workoutNameId = R.id.workout_name
    private val applyChangesId = R.id.apply_changes

    fun uncheckAllDays(): CreateWorkoutScreen {
            onView(ViewMatchers.withId(lst[2]))
                    .perform(click())
        return this
    }

    fun enterWorkoutName(name: String): CreateWorkoutScreen {
        Espresso.onView(ViewMatchers.withId(workoutNameId)).perform(ViewActions.typeText(name))
        return this
    }

    fun pressSaveButton(): MainMenuScreen {
        Espresso.onView(ViewMatchers.withId(applyChangesId)).perform(ViewActions.click())
        return MainMenuScreen()
    }

}
