package training.journal.utils.validator

import android.text.TextUtils
import java.util.regex.Pattern

object UserValidator {

    @JvmStatic
    fun validName(name: String?): Boolean = !TextUtils.isEmpty(name) &&
            Pattern.matches("[А-ЯA-Z][а-яa-z]+", name ?: "")
}