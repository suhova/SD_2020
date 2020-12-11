package training.journal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import training.journal.db.entity.ExerciseEntity
import training.journal.items.ItemsList
import training.journal.viewholders.BaseViewHolder
import training.journal.viewholders.ExerciseViewHolder
import kotlin.reflect.KClass

class ExerciseListAdapter(
    holderType: KClass<out ExerciseViewHolder>,
    @LayoutRes layoutId: Int,
    dataSource: ItemsList<ExerciseEntity>,
    onClick: (ExerciseEntity) -> Unit = {},
    private val onDeleteExerciseClick: (ExerciseEntity) -> Unit = {}
) : BaseListAdapter<ExerciseEntity>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ExerciseEntity>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ExerciseViewHolder).setClickListener { onDeleteExerciseClick.invoke(item) }
    }
}
