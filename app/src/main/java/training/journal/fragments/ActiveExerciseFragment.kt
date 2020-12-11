package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_active_exercise.view.bookmark_border
import kotlinx.android.synthetic.main.fragment_active_exercise.view.done_button
import kotlinx.android.synthetic.main.fragment_active_exercise.view.go_back
import kotlinx.android.synthetic.main.fragment_active_exercise.view.next_exercise_name
import kotlinx.android.synthetic.main.fragment_active_exercise.view.star_border
import kotlinx.android.synthetic.main.frgment_active_exercise.view.*
import training.journal.R
import training.journal.items.ExerciseItem
import training.journal.utils.recycler.adapters.BaseListAdapter
import training.journal.viewholders.ActiveExerciseViewHolder

class ActiveExerciseFragment : BaseFragment() {

    private var goBackView: ImageView? = null
    private var setStarView: ImageView? = null
    private var setBookmarkView: ImageView? = null

    private var doneButton: Button? = null
    private var nextExerciseButton: TextView? = null
    private var parametersList: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parametersList = view.parameters_view
        goBackView = view.go_back
        setStarView = view.star_border
        setBookmarkView = view.bookmark_border
        doneButton = view.done_button
        nextExerciseButton = view.next_exercise_name
        doneButton?.setOnClickListener {
            router?.showWorkoutPage()
        }
        nextExerciseButton?.setOnClickListener {
            router?.showActiveExercisePage()
        }

        val parameters = Observable.just(listOf(
                ExerciseItem("id1", "Title1", 5, 0, 0),
                ExerciseItem("id2", "Title2", 5, 1, 1),
                ExerciseItem("id3", "Title3", 5, 2, 2)
                )
        )

        val exerciseElementAdapter = BaseListAdapter(
            holderType = ActiveExerciseViewHolder::class,
            layoutId = R.layout.item_active_exercise_element,
            dataSource = parameters
        )

        parametersList?.adapter = exerciseElementAdapter
        parametersList?.layoutManager = LinearLayoutManager(activity)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_active_exercise
}
