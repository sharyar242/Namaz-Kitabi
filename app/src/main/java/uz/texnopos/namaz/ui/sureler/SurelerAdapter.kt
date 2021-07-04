package uz.texnopos.namaz.ui.sureler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_items.view.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class SurelerAdapter : RecyclerView.Adapter<SurelerAdapter.ViewHolder>(){

    var onItemClickedSureler: (id: Int , type : Int) -> Unit = {_,_ ->}

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(data: User, id: Int){
            itemView.tvItem.text = data.title
            itemView.tvItem.setOnClickListener {
                onItemClickedSureler.invoke(id+1, 3)
            }

        }
    }

    var models: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.fragment_items, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

    override fun getItemCount(): Int {
        return models.size
    }
}