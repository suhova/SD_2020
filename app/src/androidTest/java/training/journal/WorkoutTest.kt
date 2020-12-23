package training.journal

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import training.journal.mock.auth.FakeLoginActivity

@RunWith(AndroidJUnit4::class)
@LargeTest
class WorkoutTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(FakeLoginActivity::class.java)

    @Test
    fun createWorkoutWithLabelTest() {
        // в списке тренировок должна отображаться тренировка с тем именем, с которым её создали
        val name = "Name" + Math.random()
        LoginScreen().login()
                .createWorkout(name)
                .checkWorkoutLabel(name)
    }
    @Test
    fun deleteWorkoutTest() {
        //кнопки делита очищают список тренировок
        val name = "Name" + Math.random()
        LoginScreen().login()
                .createWorkout(name)
        WorkoutRecyclerView()
                .deleteAllWorkouts()
                .checkEmptyList()
    }
    @Test
    fun tryCreateWorkoutWithoutDaysTest() {
        //если не выбрать ни один день для тренировки, нельзя её сохранить
        val name = "Name" + Math.random()
        LoginScreen().login()
                .createWorkoutWithoutDays(name)
                .isCreateWorkoutScreen()
    }
}