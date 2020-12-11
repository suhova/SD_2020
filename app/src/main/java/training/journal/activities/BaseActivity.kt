package training.journal.activities

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import training.journal.lifecycle.Router
import training.journal.utils.logger.Logger

abstract class BaseActivity : AppCompatActivity() {

    var router: Router? = null
        private set

    protected val taskContainer: CompositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d(this, "onCreate")

        router = Router(this)

        setContentView(getActivityLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        taskContainer.dispose()
    }

    protected abstract fun getActivityLayoutId(): Int
}