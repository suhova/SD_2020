package training.journal.activities

import android.content.Context
import android.os.Bundle
import training.journal.R
import training.journal.api.Api
import training.journal.repository.AuthRepository
import training.journal.utils.logger.Logger
import java.net.HttpURLConnection

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token = getSharedPreferences(AuthRepository.TRAINING_PREFERENCE, Context.MODE_PRIVATE)
            .getString(AuthRepository.USER_TOKEN, null)

        if (token != null) {
            taskContainer.add(
                Api.login(token).subscribe(
                    {
                        if (it.code() == HttpURLConnection.HTTP_OK) {
                            AuthRepository.doOnLogin(this, token, false)
                            Logger.d(this, "successfully login with code ${it.code()}")
                        } else {
                            router?.showLoginPage()
                            Logger.d(this, "Incorrect password or email : ${it.code()}")
                            finish()
                        }
                    },
                    {
                        router?.showLoginPage()
                        Logger.e(this, "Login failed : ${it.message}")
                        finish()
                    }
                )
            )
        } else {
            router?.showLoginPage()
            finish()
        }
    }

    override fun getActivityLayoutId() = R.layout.activity_welcome
}