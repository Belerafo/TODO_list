package com.example.todo_list.fragmets.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import com.example.todo_list.data.models.Priority
import com.example.todo_list.data.models.ToDoData
import kotlinx.android.synthetic.main.row_layout.view.*
import java.util.zip.Inflater

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.title_txt.text = dataList[position].title
        holder.itemView.description_txt.text = dataList[position].description
        holder.itemView.row_background.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(dataList[position])
            holder.itemView.findNavController().navigate(action)
        }

        when(dataList[position].priority){
            Priority.HIGH -> holder.itemView.priority_indicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.red))
            Priority.MEDIUM -> holder.itemView.priority_indicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.yellow))
            Priority.LOW -> holder.itemView.priority_indicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.green))
        }

    }

    fun setData(toDoData: List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}