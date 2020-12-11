package training.journal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import training.journal.activities.BaseActivity
import training.journal.db.AppDatabase
import training.journal.lifecycle.Router

abstract class BaseFragment : Fragment() {

    protected var router: Router? = null
    protected val taskContainer: CompositeDisposable = CompositeDisposable()
    protected var database: AppDatabase? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        router = (activity as BaseActivity).router
        database = (activity as BaseActivity).database
        return inflater.inflate(getFragmentLayoutId(), container, false) as ViewGroup
    }

    override fun onDestroy() {
        super.onDestroy()
        taskContainer.dispose()
    }

    abstract fun getFragmentLayoutId(): Int
}
