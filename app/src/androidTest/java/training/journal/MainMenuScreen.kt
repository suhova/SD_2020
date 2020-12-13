package training.journal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class MainMenuScreen {
    fun getTimetable(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.calendar))
    }

    fun getWorkoutList(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.workout_list))
    }

    fun pressAddWorkoutButton(): CreateWorkoutScreen {
        Espresso.onView(ViewMatchers.withId(R.id.add_workout_button)).perform(ViewActions.click())
        return CreateWorkoutScreen()
    }

    fun getWorkoutLabel(name: String): ViewInteraction {
        return Espresso.onView(ViewMatchers.withText(name))
    }
}