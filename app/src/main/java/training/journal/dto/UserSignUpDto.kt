package training.journal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserSignUpDto(
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("password")
    @Expose
    val password: String,
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("gender")
    @Expose
    val gender: String?
)