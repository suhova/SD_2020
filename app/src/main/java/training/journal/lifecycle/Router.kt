package training.journal.lifecycle

import android.app.Activity
import android.content.Intent
import training.journal.activities.BaseFragmentActivity
import training.journal.lifecycle.Page.Companion.PAGE_KEY
import training.journal.utils.logger.Logger
import kotlin.reflect.full.createInstance

class Router(private val activity: Activity) {

    fun showLoginPage() {
        showPage(Page.Activity.Login)
    }

    fun showCalendarPage() {
        showPage(Page.Fragment.Calendar)
    }

    fun showWorkoutPage() {
        showPage(Page.Fragment.Workout)
    }

    fun showTrainingViewPage() {
        showPage(Page.Fragment.TrainingView)
    }

    fun showActiveExercisePage() {
        showPage(Page.Fragment.ActiveExercise)
    }

    fun showExercisePage() {
        showPage(Page.Fragment.Exercise)
    }

    fun showSettingsPage() {
        showPage(Page.Activity.Settings)
    }

    fun showAccountSettingsPage() {
        showPage(Page.Activity.AccountSettings)
    }

    fun showRegistrationPage() {
        showPage(Page.Activity.Registration)
    }

    private fun showPage(page: Page) {
        Logger.d(this, "showPage $page")
        when (page) {
            is Page.Activity -> showActivity(page)
            is Page.Fragment -> {
                if (activity is BaseFragmentActivity) {
                    replaceFragment(page)
                } else {
                    showActivityWithFragment(page)
                }
            }
        }
    }

    private fun showActivity(page: Page.Activity) {
        val intent = Intent(activity, page.clazz.java)
        activity.startActivity(intent)
    }

    private fun showActivityWithFragment(page: Page.Fragment) {
        val intent = Intent(activity, BaseFragmentActivity::class.java)
        intent.putExtra(PAGE_KEY, page)
        activity.startActivity(intent)
    }

    private fun replaceFragment(page: Page.Fragment) {
        (activity as? BaseFragmentActivity)?.setFragment(page.clazz.createInstance())
    }
}