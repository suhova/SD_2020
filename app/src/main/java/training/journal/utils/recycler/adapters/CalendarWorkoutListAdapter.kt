package training.journal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import training.journal.db.entity.WorkoutEntity
import training.journal.items.ItemsList
import training.journal.viewholders.BaseViewHolder
import training.journal.viewholders.WorkoutViewHolder
import kotlin.reflect.KClass

class CalendarWorkoutListAdapter(
    holderType: KClass<out WorkoutViewHolder>,
    @LayoutRes layoutId: Int,
    dataSource: ItemsList<WorkoutEntity>,
    onClick: (WorkoutEntity) -> Unit = {},
    private val onStartWorkoutClick: (WorkoutEntity) -> Unit = {},
    private val onDeleteWorkoutClick: (WorkoutEntity) -> Unit = {}
) : BaseListAdapter<WorkoutEntity>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<WorkoutEntity>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as WorkoutViewHolder).setClickListeners(
            { onStartWorkoutClick.invoke(item) },
            { onDeleteWorkoutClick.invoke(item) }
        )
    }
}