package com.example.noticiasapp

import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso

class MyAdapter(
    private val listaNoticias:List<TempModel>,//datos
    private val contexto:MainActivity,//En cual activity cargar el recycler
    private val recyclerView:androidx.recyclerview.widget.RecyclerView
):androidx.recyclerview.widget.RecyclerView.Adapter<MyHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //Aqui seteo el layout en este caso la card
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val noticia=listaNoticias[position]
        holder.tituloTextView.text=noticia.titulo
        holder.sourceTextView.text=noticia.sourceName
        holder.descripcionTextView.text=noticia.descripcion
        holder.idTextView.text=noticia.id.toString()
        Picasso.get().load(noticia.imgUrl).placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_broken_image_24).into(holder.imgNoticia);

    }

    override fun getItemCount(): Int {
        return listaNoticias.size
    }

}