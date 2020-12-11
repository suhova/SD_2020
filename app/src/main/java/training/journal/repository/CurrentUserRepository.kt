package training.journal.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import training.journal.model.UserInfo

object CurrentUserRepository {

    val CURRENT_USER_EMPTY: UserInfo = UserInfo(
            id = -1,
            uid = "-1",
            lastName = "lastName",
            firstName = "firstName",
            fatherName = "fatherName",
            genderType = UserInfo.GenderType.MALE,
            email = "email",
            birthday = null,
            pictureUrlStr = null)

    var currentUser: MutableLiveData<UserInfo> = MutableLiveData()
        internal set

    fun getCurrentUserToken(context: Context): String? =
            context.getSharedPreferences(AuthRepository.TRAINING_PREFERENCE, Context.MODE_PRIVATE)
                    .getString(AuthRepository.USER_TOKEN, null)
}