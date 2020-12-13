package training.journal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import okhttp3.internal.immutableListOf

class CreateWorkoutScreen {

    private val lst = immutableListOf(R.id.day1, R.id.day2, R.id.day3, R.id.day4, R.id.day5, R.id.day6, R.id.day7)

    fun checkDay(index: Int): CreateWorkoutScreen {
        assert(1 <= index)
        assert(index <= 7)
        Espresso.onView(ViewMatchers.withId(lst[index])).perform(ViewActions.click())
        return this
    }

    fun enterWorkoutName(name: String): CreateWorkoutScreen {
        Espresso.onView(ViewMatchers.withId(R.id.workout_name)).perform(ViewActions.typeText(name))
        return this
    }

    fun pressSaveButton(): MainMenuScreen {
        Espresso.onView(ViewMatchers.withId(R.id.apply_changes)).perform(ViewActions.click())
        return MainMenuScreen()
    }

}
