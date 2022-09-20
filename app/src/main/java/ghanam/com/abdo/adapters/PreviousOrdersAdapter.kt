package ghanam.com.abdo.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import ghanam.com.abdo.databinding.PreviousOrderCardBinding
import ghanam.com.abdo.dataclasses.PreviousOrder
import java.text.SimpleDateFormat as SimpleDateFormat1


class PreviousOrdersAdapter(  private val items: MutableList<PreviousOrder>) : RecyclerView.Adapter<PreviousOrdersAdapter.TaskViewHolder>() {
    class TaskViewHolder(val binding: PreviousOrderCardBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(PreviousOrderCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.apply {
            totalTxt.text=currentItem.total.toString()
            val parser = SimpleDateFormat1("yyyy-MM-dd'T'HH:mm:ss")
            val dateFormatter = SimpleDateFormat1("dd/MM/yyyy")
            val timeFormatter = SimpleDateFormat1("HH:mm")
            val date = parser.parse(currentItem.date.toString())?.let { dateFormatter.format(it) }
            val time = parser.parse(currentItem.date.toString())?.let { timeFormatter.format(it) }
            dateText.text=date
            timeText.text=time
        }
    }


}