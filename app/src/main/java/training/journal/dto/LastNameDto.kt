package training.journal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LastNameDto(
    @SerializedName("last_name")
    @Expose
    var lastName: String
)