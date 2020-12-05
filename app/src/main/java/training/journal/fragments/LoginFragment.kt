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

@ContainerOptions(cache = CacheImplementation.NO_CACHE)
class LoginFragment : BaseFragment() {

    private var imageView: ImageView? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var forgotPasswordTextView: TextView? = null
    private var notExistAccTextView: TextView? = null
    private var loginButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)
        imageView = rootView?.findViewById(R.id.person_iv) as ImageView
        emailEditText = rootView.findViewById(R.id.email_et) as EditText
        passwordEditText = rootView.findViewById(R.id.password_et) as EditText
        forgotPasswordTextView = rootView.findViewById(R.id.forgot_password_tv) as TextView
        notExistAccTextView = rootView.findViewById(R.id.not_exist_acc_tv) as TextView
        loginButton = rootView.findViewById(R.id.login_button)
        return rootView
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_login
}