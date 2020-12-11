package training.journal.utils.auth

import androidx.annotation.IntDef

@IntDef(
        SignUpDataCorrectType.INCORRECT_EMAIL,
        SignUpDataCorrectType.INCORRECT_PASSWORD,
        SignUpDataCorrectType.INCORRECT_CONFIRM_PASSWORD,
        SignUpDataCorrectType.INCORRECT_LAST_NAME,
        SignUpDataCorrectType.INCORRECT_FIRST_NAME,
        SignUpDataCorrectType.CORRECT
)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class SignUpDataCorrectType {
    companion object {
        const val INCORRECT_EMAIL = 0
        const val INCORRECT_PASSWORD = 1
        const val INCORRECT_CONFIRM_PASSWORD = 2
        const val INCORRECT_LAST_NAME = 3
        const val INCORRECT_FIRST_NAME = 4
        const val CORRECT = 5
    }
}