package training.journal.repository

import android.content.Context
import training.journal.activities.BaseActivity

object AuthRepository {

    const val TRAINING_PREFERENCE = "Training"
    const val USER_TOKEN = "user_token_key"

    fun doOnLogin(activity: BaseActivity, token: String, needRemember: Boolean) {
        activity.apply {
            if (needRemember) {
                getSharedPreferences(TRAINING_PREFERENCE, Context.MODE_PRIVATE).edit().putString(USER_TOKEN, token).apply()
            }
            router?.showWorkoutPage()
            finish()
        }
    }

    fun doOnLogout(activity: BaseActivity) {
        activity.apply {
            getSharedPreferences("Training", Context.MODE_PRIVATE).edit().remove(USER_TOKEN).apply()
            router?.showLoginPage()
            finish()
        }
    }
}