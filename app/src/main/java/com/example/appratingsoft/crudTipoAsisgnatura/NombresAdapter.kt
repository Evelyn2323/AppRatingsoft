//package com.example.appratingsoft.crudTipoAsisgnatura
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.appratingsoft.R
//
//class NombresAdapter(private val itemClickListener: OnItemClickListener) :
//    ListAdapter<Nombre, NombresAdapter.ViewHolder>(DiffCallback()) {
//
//    interface OnItemClickListener {
//        fun onItemEditar(posicion: Int, elemento: Nombre)
//        fun onItemBorrar(posicion: Int)
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val tvid: TextView = itemView.findViewById(R.id.tvid)
//        private val tvnombreTipoAsignatura: TextView = itemView.findViewById(R.id.tvnombreTipoAsignatura)
//        private val tvdescripcion: TextView = itemView.findViewById(R.id.tvdescripcion)
//        private val btnEditar: Button = itemView.findViewById(R.id.btnEdit)
//        private val btnBorrar: Button = itemView.findViewById(R.id.btnDelete)
//
//        fun bind(item: Nombre, clickListener: OnItemClickListener) {
//            tvnombreTipoAsignatura.text = item.nombreTipoAsignatura
//
//            btnEditar.setOnClickListener { clickListener.onItemEditar(adapterPosition, item) }
//            btnBorrar.setOnClickListener { clickListener.onItemBorrar(adapterPosition) }
//        }
//    }
//
//    private class DiffCallback : DiffUtil.ItemCallback<Nombre>() {
//        override fun areItemsTheSame(oldItem: Nombre, newItem: Nombre): Boolean {
//            return oldItem.nombreTipoAsignatura == newItem.nombreTipoAsignatura
//        }
//
//        override fun areContentsTheSame(oldItem: Nombre, newItem: Nombre): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_crud, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getItem(position), itemClickListener)
//    }
//}
