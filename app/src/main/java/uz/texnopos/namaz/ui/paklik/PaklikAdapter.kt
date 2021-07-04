package uz.texnopos.namaz.ui.paklik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_items.view.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class PaklikAdapter: RecyclerView.Adapter<PaklikAdapter.ViewHolder>() {

    var onItemClicked: (id: Int) -> Unit = {_ ->}

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(data: User, id: Int){
            itemView.tvItem.text = data.title
            itemView.tvItem.setOnClickListener {
                onItemClicked.invoke(id+1)
            }

        }
    }

    var models: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaklikAdapter.ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.fragment_items, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: PaklikAdapter.ViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

    override fun getItemCount(): Int {
        return models.size
    }
}