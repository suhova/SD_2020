package training.journal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import training.journal.viewholders.BaseViewHolder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class BaseListAdapter<Item>(
    private val holderType: KClass<out BaseViewHolder<Item>>,
    @LayoutRes private val layoutId: Int,
    private val dataSource: Observable<List<Item>>,
    private val onClick: (Item) -> Unit = {}
) : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    private var data = listOf<Item>()

    private var dataSourceSubscription: Disposable? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        dataSourceSubscription = dataSource.subscribe {
            data = it
            notifyDataSetChanged()
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        dataSourceSubscription?.dispose()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(
                        layoutId,
                        parent,
                        false
                )
        return holderType.primaryConstructor?.call(view)
                ?: throw NoSuchMethodException("No constructor with parameter of type View")
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClick.invoke(item) }
    }
}