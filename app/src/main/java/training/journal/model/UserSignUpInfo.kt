package training.journal.model

import android.os.Parcel
import android.os.Parcelable
import training.journal.dto.UserSignUpDto

data class UserSignUpInfo(
    val email: String,
    val password: String,
    val confirmPassword: String,
    val lastName: String,
    val firstName: String,
    val genderType: String?
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<UserSignUpInfo> {
        private const val NAME_UNKNOWN = ""

        override fun createFromParcel(parcel: Parcel): UserSignUpInfo {
            return UserSignUpInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserSignUpInfo?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.apply {
            writeString(email)
            writeString(password)
            writeString(confirmPassword)
            writeString(lastName)
            writeString(firstName)
            writeString(genderType)
        }
    }

    override fun describeContents(): Int = 0

    fun toUserSignUpDto(): UserSignUpDto = UserSignUpDto(
            email,
            password,
            lastName,
            firstName,
            genderType
    )
}