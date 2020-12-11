package training.journal.activities.auth

import android.graphics.Color
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Response
import training.journal.R
import training.journal.activities.BaseActivity
import training.journal.api.Api
import training.journal.api.responses.MessageResponse
import training.journal.model.UserSignUpInfo
import training.journal.utils.auth.AuthorizationHelper
import training.journal.utils.auth.SignUpDataCorrectType
import training.journal.utils.logger.Logger
import training.journal.utils.toast.ToastUtils
import java.net.HttpURLConnection

class RegistrationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cancel_button.setOnClickListener { finish() }
        confirm_button.setOnClickListener {
            resetRequiredTips()
            val userSignUpInfo = UserSignUpInfo(
                    email_et.text.toString(),
                    password_et.text.toString(),
                    confirm_password_et.text.toString(),
                    last_name_et.text.toString(),
                    first_name_et.text.toString(),
                    user_gender.selectedItem as? String
            )
            when (AuthorizationHelper.checkCorrectnessInputData(userSignUpInfo)) {
                SignUpDataCorrectType.INCORRECT_EMAIL -> {
                    email_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_email)
                }
                SignUpDataCorrectType.INCORRECT_PASSWORD -> {
                    password_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_password)
                }
                SignUpDataCorrectType.INCORRECT_CONFIRM_PASSWORD -> {
                    confirm_password_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_confirm_passowrd)
                }
                SignUpDataCorrectType.INCORRECT_LAST_NAME -> {
                    last_name_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_last_name)
                }
                SignUpDataCorrectType.INCORRECT_FIRST_NAME -> {
                    first_name_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_first_name)
                }
                SignUpDataCorrectType.CORRECT -> taskContainer.add(
                        Api.createUser(userSignUpInfo.toUserSignUpDto()).subscribe(
                                { onResponse(it) },
                                { onFail(it) }
                        )
                )
            }
        }
    }

    private fun onResponse(response: Response<MessageResponse>) {
        when (response.code()) {
            HttpURLConnection.HTTP_CREATED -> {
                ToastUtils.showShortToast(this, R.string.successfully)
                finish()
                Logger.d(this, "successfully sign up with code ${response.code()}")
            }
            HttpURLConnection.HTTP_BAD_REQUEST -> {
                MaterialDialog(this).show {
                    title(R.string.cannot_sign_up)
                    message(text = response.body()?.message
                            ?: getString(R.string.user_exist))
                    negativeButton(R.string.close) {
                        it.cancel()
                    }
                }
                Logger.d(this, "fail registration ${response.code()} : ${response.body()?.message}")
            }
            else -> {
                ToastUtils.showShortToast(this, R.string.failed_registr)
                Logger.d(this, "unsupported code ${response.code()}")
            }
        }
    }

    private fun onFail(throwable: Throwable) {
        ToastUtils.showErrorToast(this)
        Logger.e(this, throwable.message ?: throwable)
    }

    private fun resetRequiredTips() {
        email_required.setTextColor(Color.BLACK)
        password_required.setTextColor(Color.BLACK)
        confirm_password_required.setTextColor(Color.BLACK)
        last_name_required.setTextColor(Color.BLACK)
        first_name_required.setTextColor(Color.BLACK)
        user_gender_required.setTextColor(Color.BLACK)
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_registration
}