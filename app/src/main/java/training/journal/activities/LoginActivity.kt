package training.journal.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*
import training.journal.R

class LoginActivity : BaseActivity() {

    private var imageView: ImageView? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var forgotPasswordTextView: TextView? = null
    private var notExistAccTextView: TextView? = null
    private var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageView = person_iv
        emailEditText = email_et
        passwordEditText = password_et
        forgotPasswordTextView = forgot_password_tv
        notExistAccTextView = not_exist_acc_tv
        loginButton = login_button
        loginButton?.setOnClickListener {
            router?.showWorkoutPage()
            finish()
        }
    }

    override fun getActivityLayoutId() = R.layout.activity_login
}
