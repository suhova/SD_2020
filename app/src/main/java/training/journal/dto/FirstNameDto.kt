package training.journal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FirstNameDto(
    @SerializedName("first_name")
    @Expose
    val firstName: String
)