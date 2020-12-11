package training.journal.repository

import training.journal.model.UserInfo

object CurrentUserRepository {

    private val currentUser: UserInfo = UserInfo(
            uid = 0,
            lastName = "lastName",
            firstName = "firstName",
            fatherName = "fatherName",
            genderType = UserInfo.GenderType.MALE,
            email = "email",
            birthday = null,
            pictureUrlStr = null)

    @JvmStatic
    fun getCurrentUserInfo(): UserInfo = currentUser
}