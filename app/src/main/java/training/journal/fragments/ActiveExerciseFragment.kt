package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_active_exercise.view.*
import training.journal.R

class ActiveExerciseFragment : BaseFragment() {

    private var goBackView: ImageView? = null
    private var setStarView: ImageView? = null
    private var setBookmarkView: ImageView? = null
    private var parameterGoal1EditText: EditText? = null
    private var parameterGoal2EditText: EditText? = null
    private var parameterGoal3EditText: EditText? = null
    private var doneButton: Button? = null
    private var nextExerciseView: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBackView = view.go_back
        setStarView = view.star_border
        setBookmarkView = view.bookmark_border
        parameterGoal1EditText = view.parameter1_goal
        parameterGoal2EditText = view.parameter2_goal
        parameterGoal3EditText = view.parameter3_goal
        doneButton = view.done_button
        nextExerciseView = view.next_exercise_name
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_active_exercise
}