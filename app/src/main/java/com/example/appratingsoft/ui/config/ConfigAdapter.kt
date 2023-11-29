package com.example.appratingsoft

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.databinding.ItemConfiguracionBinding

class ConfigAdapter : RecyclerView.Adapter<ConfigViewHolder>() {

    private val configuracionItems: MutableList<ConfiguracionItem> = mutableListOf()

    fun setData(items: List<ConfiguracionItem>) {
        configuracionItems.clear()
        configuracionItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfiguracionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemConfiguracionBinding.inflate(inflater, parent, false)
        return ConfiguracionViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ConfiguracionViewHolder, position: Int) {
        holder.bind(configuracionItems[position])
    }

    override fun getItemCount(): Int = configuracionItems.size
}
