package training.journal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import training.journal.model.UserInfo
import java.util.Date

data class UserDto(
    @SerializedName("id")
    @Expose
    val id: Long,
    @SerializedName("uid")
    @Expose
    val uid: String?,
    @SerializedName("last_name")
    @Expose
    var lastName: String,
    @SerializedName("first_name")
    @Expose
    var firstName: String,
    @SerializedName("father_name")
    @Expose
    var fatherName: String?,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("birthday")
    @Expose
    val birthday: Date?,
    @SerializedName("gender")
    @Expose
    val gender: String?,
    @SerializedName("avatarUrl")
    @Expose
    var pictureUrlStr: String?
) {

    fun toUserInfo(): UserInfo = UserInfo(
            id,
            uid ?: "-1",
            lastName,
            firstName,
            fatherName,
            UserInfo.GenderType.fromApiStr(gender),
            email,
            birthday,
            pictureUrlStr
    )
}