package training.journal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not

class WorkoutRecyclerView {
    private val recyclerMatcher = R.id.workout_list
    private val deleteMatcher = R.id.delete

    fun deleteAllWorkouts(): WorkoutRecyclerView {
        val childCount = getRecyclerViewChildCount()
        for (i in 0..childCount) {
            clickChildViewWithId(deleteMatcher)
        }
        return this
    }

    fun checkEmptyList(): WorkoutRecyclerView {
        val childCount = getRecyclerViewChildCount()
        for (i in 0..childCount) {
            checkItem(deleteMatcher)
        }
        return this
    }

    fun getRecyclerViewChildCount(): Int {
        val count = intArrayOf(0)
        Espresso.onView(ViewMatchers.withId(recyclerMatcher)).perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(RecyclerView::class.java)
            }

            override fun getDescription(): String {
                return ""
            }

            override fun perform(uiController: UiController, view: View) {
                val rv = view as RecyclerView
                count[0] = rv.childCount
            }
        })
        return count[0]
    }

    fun clickChildViewWithId(id: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(RecyclerView::class.java)
            }

            override fun getDescription(): String {
                return ""
            }

            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById<View>(id)
                v.performClick()
            }
        }
    }

    fun checkItem(id: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(RecyclerView::class.java)
            }

            override fun getDescription(): String {
                return ""
            }

            override fun perform(uiController: UiController, view: View) {
                Espresso.onView(ViewMatchers.withId(id)).check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))
            }
        }
    }
}