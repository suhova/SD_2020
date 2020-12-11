package training.journal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import training.journal.model.UserInfo
import java.util.Date

data class UserDto(
    @SerializedName("uid")
    @Expose
    val uid: Long,
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("father_name")
    @Expose
    val fatherName: String?,
    @SerializedName("gender")
    @Expose
    val gender: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("birthday")
    @Expose
    val birthday: Date?,
    @SerializedName("picture_url")
    @Expose
    val pictureUrlStr: String?
) {

    fun toUserInfo(): UserInfo = UserInfo(
            uid,
            lastName,
            firstName,
            fatherName,
            UserInfo.GenderType.fromApiStr(gender),
            email,
            birthday,
            pictureUrlStr
    )
}