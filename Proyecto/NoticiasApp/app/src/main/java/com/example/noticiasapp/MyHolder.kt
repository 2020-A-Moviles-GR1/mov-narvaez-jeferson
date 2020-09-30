package com.example.noticiasapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
//Aqui en el holder puedo ejecutar acciones en el init si es que capturo algún elemento
class MyHolder (view:View):androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    val idTextView:TextView
    val tituloTextView: TextView
    val imgNoticia:ImageView
    val descripcionTextView:TextView
    val sourceTextView:TextView
    init{
        idTextView=view.findViewById(R.id.tv_id_noticia)
        tituloTextView=view.findViewById(R.id.tv_titulo)
        descripcionTextView=view.findViewById(R.id.tv_descripcion)
        sourceTextView=view.findViewById(R.id.tv_source_name)
        imgNoticia=view.findViewById(R.id.iv_imagen_noticia)

    }
}