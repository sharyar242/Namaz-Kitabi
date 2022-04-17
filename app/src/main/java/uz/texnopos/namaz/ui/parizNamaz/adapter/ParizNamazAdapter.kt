package uz.texnopos.namaz.ui.parizNamaz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_items.view.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class ParizNamazAdapter: RecyclerView.Adapter<ParizNamazAdapter.ParizNamazViewHolder>() {

    var onItemClickedParizNamaz: (id: Int) -> Unit = {_->}

    inner class ParizNamazViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun parizNamazPopulateModel(data: User, id: Int){
            itemView.tvItem.text = data.title
            itemView.tvItem.setOnClickListener {
                onItemClickedParizNamaz.invoke(id+1)
            }
        }
    }

    var models: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParizNamazViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.fragment_items,parent,false)
        return ParizNamazViewHolder(item)
    }

    override fun onBindViewHolder(holder: ParizNamazViewHolder, position: Int) {
        holder.parizNamazPopulateModel(models[position],position)
    }

    override fun getItemCount(): Int = models.size
}