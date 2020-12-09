package training.journal.utils.toast

import android.content.Context
import android.widget.Toast
import training.journal.R

// todo потом добавилю побольше разных тостов
object ToastUtils {

    @JvmStatic
    fun showErrorToast(context: Context) {
        Toast.makeText(context, R.string.error, Toast.LENGTH_LONG).show()
    }

    @JvmStatic
    fun showLongToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    @JvmStatic
    fun showShortToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}