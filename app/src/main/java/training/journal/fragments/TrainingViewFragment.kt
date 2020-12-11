package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import training.journal.R

class TrainingViewFragment : BaseFragment() {

    private var startTrainingButton: Button? = null
    private var trainingCategoryView: ImageView? = null
    private var trainingNameText: TextView? = null
    private var exerciseList: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_view_training
}