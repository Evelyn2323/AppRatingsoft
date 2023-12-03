//package com.example.appratingsoft.crudTipoAsisgnatura
//
//import com.example.appratingsoft.R
//import android.content.Context
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.appcompat.app.AlertDialog
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.example.appratingsoft.ui.TipoAsignatura.TipoAsignaturaAdapter
//
//class TipoAsignaturaCrudAdapter(
//    var context: Context,
//    var tipoasignaturacrud: List<TipoAsignaturaCrud>
//): RecyclerView.Adapter<TipoAsignaturaAdapter.TipoAsignaturaViewHolder >() {
//
//
//    private var Onclick: OnItemClicked? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipoAsignaturaViewHolder {
//        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_crud,parent,false)
//        return TipoAsignaturaViewHolder(vista)
//    }
//
//    override fun getItemCount(): Int {
//        val itemCount = tipoasignaturacrud.size
//        Log.d("ItemCount", "El número de elementos en la lista es $itemCount")
//        return itemCount
//    }
//    fun updateData(newProducts: List<TipoAsignaturaCrud>) {
//        //  products.clear()
//        //  products.addAll(newProducts)
//        notifyDataSetChanged()
//    }
//
//
//
//
//
//    override fun onBindViewHolder(holder: TipoAsignaturaViewHolder, position: Int) {
//        val TipAsig = tipoasignaturacrud[position]
//
//        with(holder) {
//            tvIdProducto.text = TipAsig.id.toString()
//            tvNombre.text = TipAsig.nombreTipoAsignatura
//            tvdescription.text = TipAsig.descripcion
//
//        }
//
//        holder.btnEditar.setOnClickListener {
//            Onclick?.editarProduct(TipAsig)
//        }
//
//        holder.btnBorrar.setOnClickListener {
//            Onclick?.borrarProduct(TipAsig.id)
//        }
//
//        holder.Agregar.setOnClickListener {
//            mostrarDialogo(TipAsig)
//        }
//
//    }
//
//    private fun mostrarDialogo(TipAsig: TipoAsignaturaCrud) {
//        val builder = AlertDialog.Builder(context)
//        val inflater = LayoutInflater.from(context)
//        val dialogView = inflater.inflate(R.layout.model_crud, null)
//        builder.setView(dialogView)
//
//        val editText1 = dialogView.findViewById<EditText>(R.id.nombreTipoAsignatura)
//        val editText2 = dialogView.findViewById<EditText>(R.id.description)
//
//        // Establecer los datos del producto en los campos del diálogo
//        editText1.setText(TipAsig.nombreTipoAsignatura)
//        editText2.setText(TipAsig.descripcion)
//
//
//        builder.setTitle("Editar Producto")
//            .setPositiveButton("Aceptar") { dialog, which ->
//                val input1 = editText1.text.toString()
//                val input2 = editText2.text.toString()
//
//                // Realizar la acción necesaria con los datos editados
//                // Por ejemplo, puedes llamar a una función para actualizar el producto
//                //updateProduct(product.id, input1, input2)
//
//                // updateProduct(TraerProduct(input1, input2, input3, input4, input5, input6), product.id.toString())
//
//            }
//            .setNegativeButton("Cancelar") { dialog, which ->
//                // Acciones al cancelar la edición del producto
//            }
//
//        val alertDialog = builder.create()
//        alertDialog.show()
//    }
//
//    inner class TipoAsignaturaViewHolder(itemView: View): ViewHolder(itemView){
//
//        val tvIdProducto = itemView.findViewById(R.id.tvIdProducto) as TextView
//        val tvNombre = itemView.findViewById(R.id.tvNombre) as TextView
//        val tvdescription = itemView.findViewById(R.id.tvdescription) as TextView
//
//        val btnEditar = itemView.findViewById(R.id.btnEditar) as Button
//        val btnBorrar = itemView.findViewById(R.id.btnBorrar) as Button
//        val Agregar = itemView.findViewById(R.id.Agregar) as Button
//
//    }
//    interface  OnItemClicked{
//        fun editarProduct(tipoasignaturacrud: TipoAsignaturaCrud)
//        fun borrarProduct(id: Int)      }
//
//    fun setOnClick(onClick: OnItemClicked?) {
//        this.Onclick = onClick
//    }
//
//
//
//
//}