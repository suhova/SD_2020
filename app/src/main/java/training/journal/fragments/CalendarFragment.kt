package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import training.journal.R

class CalendarFragment : BaseFragment() {

    var calendar: CalendarView? = null
    var buttonAddWorkout: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar = view.calendar
        buttonAddWorkout = view.add_workout_button
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_calendar

}