package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_exercise.*
import training.journal.R
import training.journal.items.ExerciseItem
import training.journal.utils.recycler.adapters.BaseListAdapter
import training.journal.viewholders.ExerciseElementViewHolder

class ExerciseFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var saveButton: Button? = null
    private var cancelButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        saveButton = save
        cancelButton = cancel

//        Smth like
//        exerciseUtils.createExercise(exerciseItem)
//        or
//        exerciseUtils.updateExercise(exerciseItem)
//        where exerciseItem: ExerciseItem(name: String, elements: List<ExerciseElement)

//        saveButton?.setOnClickListener { (activity as? ExerciseListener)?.onExerciseSaved(0) }

//        Smth like
//        fragmentManager.goBack()
//        cancelButton?.setOnClickListener { (activity as? ExerciseListener)?.onExerciseCanceled(0) }

        val elements = Observable.just(listOf(
                ExerciseItem("id1", "Title1", 5, 0, 0),
                ExerciseItem("id2", "Title2", 5, 1, 1),
                ExerciseItem("id3", "Title3", 5, 2, 2)
        ))

        val exerciseElementAdapter = BaseListAdapter(
                holderType = ExerciseElementViewHolder::class,
                layoutId = R.layout.item_exercise_element,
                dataSource = elements
        )

        recyclerView?.adapter = exerciseElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_exercise
}
