package training.journal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.extensions.CacheImplementation
import kotlinx.android.extensions.ContainerOptions
import training.journal.R

class LoginFragment : BaseFragment() {

    private var imageView: ImageView? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var forgotPasswordTextView: TextView? = null
    private var notExistAccTextView: TextView? = null
    private var loginButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.person_iv) as ImageView
        emailEditText = view.findViewById(R.id.email_et) as EditText
        passwordEditText = view.findViewById(R.id.password_et) as EditText
        forgotPasswordTextView = view.findViewById(R.id.forgot_password_tv) as TextView
        notExistAccTextView = view.findViewById(R.id.not_exist_acc_tv) as TextView
        loginButton = view.findViewById(R.id.login_button)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_login
}