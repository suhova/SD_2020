package training.journal.utils

import java.lang.Exception
import java.util.Date

object DateUtils {

    fun fromDdMmYyyyToDate(date: String): Date? {
        try {
            val dayStr = date.substring(0, 2)
            val day = Integer.parseInt(dayStr)

            val monthStr = date.substring(3, 5)
            val month = Integer.parseInt(monthStr)

            val yearStr = date.substring(6)
            val year = Integer.parseInt(yearStr)

            val daysInMonth = getDaysInMonth(month, year)
            return if (year >= 0 && month <= 12 && month > 0 && day > 0 && day <= daysInMonth) {
                Date(year, month, day)
            } else {
                null
            }
        } catch (e: Exception) {
            return null
        }
    }

    fun getDaysInMonth(month: Int, year: Int): Int {
        return when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> if (year % 4 == 0) 29 else 28
            else -> 0
        }
    }
}