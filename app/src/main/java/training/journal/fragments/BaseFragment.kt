package training.journal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import training.journal.activities.BaseActivity
import training.journal.lifecycle.Router

abstract class BaseFragment : Fragment() {

    protected var router: Router? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        router = (activity as BaseActivity).router
        return inflater.inflate(getFragmentLayoutId(), container, false) as ViewGroup
    }

    abstract fun getFragmentLayoutId(): Int
}
