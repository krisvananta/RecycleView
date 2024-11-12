package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ItemDisasterBinding


typealias OnClickDisaster = (Disaster) -> Unit

// DisasterAdapter abstract class extends RecyclerView.Adapter with "():"
class DisasterAdapter(private val listDisaster: List<Disaster>, private val onClickDisaster: OnClickDisaster): RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind (data: Disaster) {
                    with(binding) {
                        tvDisasterName.text = data.nameDisaster
                        tvDisasterType.text = data.disasterType

                        itemView.setOnClickListener {
                            onClickDisaster(data)
                        }
                    }
                }
    }

    // viewnya apa?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    // ada berapa item?
    override fun getItemCount(): Int {
        return listDisaster.size
    }

    // bind data ke view
    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind (listDisaster[position])
    }
}