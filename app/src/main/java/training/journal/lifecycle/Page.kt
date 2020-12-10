package training.journal.lifecycle

import training.journal.activities.LoginActivity
import training.journal.activities.settings.SettingsActivity
import training.journal.fragments.ActiveExerciseFragment
import training.journal.fragments.BaseFragment
import training.journal.fragments.CalendarFragment
import training.journal.fragments.ExerciseFragment
import training.journal.fragments.WorkoutFragment
import java.io.Serializable
import kotlin.reflect.KClass

sealed class Page : Serializable {

    sealed class Activity : Page() {

        abstract val clazz: KClass<out android.app.Activity>

        object Login : Activity() {
            override val clazz = LoginActivity::class
        }

        object Settings : Activity() {
            override val clazz = SettingsActivity::class
        }
    }

    sealed class Fragment : Page() {

        abstract val clazz: KClass<out BaseFragment>

        object ActiveExercise : Fragment() {
            override val clazz = ActiveExerciseFragment::class
        }

        object Calendar : Fragment() {
            override val clazz = CalendarFragment::class
        }

        object Exercise : Fragment() {
            override val clazz = ExerciseFragment::class
        }

        object Workout : Fragment() {
            override val clazz = WorkoutFragment::class
        }
    }

    companion object {
        val PAGE_KEY = "PAGE"
    }
}