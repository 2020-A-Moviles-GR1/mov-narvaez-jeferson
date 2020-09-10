package com.example.examen1bimestre

import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
class BddService {
    companion object{
        val urlPrincipal="http://192.168.100.56:1337"

        var listaCanciones= listOf<Cancion>()
        var cancion: Cancion? =null
        var listaAcordes= arrayListOf<Acorde>(
            Acorde("c","do",R.drawable.c),
            Acorde("cm","dom",R.drawable.dom),
            Acorde("d","re",R.drawable.d),
            Acorde("dm","rem",R.drawable.rem),
            Acorde("e","mi",R.drawable.e),
            Acorde("em","mim",R.drawable.mim),
            Acorde("f","fa",R.drawable.f),
            Acorde("fm","fam",R.drawable.fam),
            Acorde("g","sol",R.drawable.g),
            Acorde("gm","solm",R.drawable.solm),
            Acorde("a","la",R.drawable.a),
            Acorde("am","lam",R.drawable.lam),
            Acorde("b","si",R.drawable.b),
            Acorde("bm","sim",R.drawable.sim)
        )
        fun buscarAcorde(chord:String): Acorde? {
            var acordeEncontrado=listaAcordes.find{acorde -> acorde.notacionInglesa
                .equals(chord.toLowerCase())||acorde.notacionLatina.equals(chord.toLowerCase()) }
            return acordeEncontrado
        }
        fun getCanciones() {

            val url= "$urlPrincipal/cancion"
            url.httpGet().responseString{
                    request, response, result ->
                when(result){
                    is Result.Success->{
                        val data=result.get()
                        Log.i("Http data cancion","Data cancion: $data")
                        val canciones=Klaxon().parseArray<Cancion>(data)
                        if(canciones!=null){
                            this.listaCanciones=canciones
                            canciones.forEach {
                                Log.i("Http-Klaxon-canciones","Nombre ${it.nombre} , : ${it.autor}")
                                }

                        }

                    }
                    is Result.Failure->{
                        val ex=result.getException()
                        Log.i("Http Exception","Error obteniendo canciones: $ex.message")

                    }
                }
            }.join()
        }
        fun getCancion(id:Int) {

            val url= "$urlPrincipal/cancion/${id}"
            url.httpGet().responseString{
                    request, response, result ->
                when(result){
                    is Result.Success->{
                        val data=result.get()
                        Log.i("Http data cancion","Data cancion: $data")
                        val cancion=Klaxon().parse<Cancion>(data)
                        if(cancion!=null){
                            this.cancion=cancion
                            Log.i("Http-Klaxon-canciones","Nombre ${cancion.nombre} , : ${cancion.autor}")


                        }

                    }
                    is Result.Failure->{
                        val ex=result.getException()
                        Log.i("Http Exception","Error obteniendo cancion: $ex.message")

                    }
                }
            }.join()
        }
        fun postCancion(nombre:String,autor:String,genero:String,acordes:String){
            val url= "$urlPrincipal/cancion"
            val parametrosUsuario=listOf(
                "nombre" to nombre,
                "autor" to autor,
                "genero" to genero,
                "acordes" to acordes
            )
            url.httpPost(parametrosUsuario).responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                        Log.i("http-klaxon-post-cancion","Error:${error}")
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                        Log.i("Http-klaxon","Agregado ${cancionString}")
                    }
                }
            }.join()

        }
        fun deleteCancion(id:Int){
            val url= "$urlPrincipal/cancion/${id}"

            url.httpDelete().responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                        Log.i("http-klaxon-delete-cancion","Error:${error}")
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                        Log.i("Http-klaxon","eliminado ${cancionString}")
                    }
                }
            }.join()
        }

        fun putCancion(id:Int,nombre:String,autor:String,genero:String,acordes:String){
            val url= "$urlPrincipal/cancion/${id}"
            val parametrosUsuario=listOf(
                "nombre" to nombre,
                "autor" to autor,
                "genero" to genero,
                "acordes" to acordes
            )
            url.httpPut(parametrosUsuario).responseString{
                    req,res,result->
                when(result){
                    is Result.Failure->{
                        val error= result.getException()
                        Log.i("http-klaxon-put-cancion","Error:${error}")
                    }
                    is Result.Success->{
                        val cancionString=result.get()
                        Log.i("Http-klaxon","Modificado ${cancionString}")
                    }
                }
            }.join()
        }
        fun agregarCancion(nombre:String,autor:String,genero:String,acordes:String){
           postCancion(nombre,autor,genero,acordes)
            getCanciones()
        }
        fun elimarCancion(id:Int){
            deleteCancion(id)
            getCanciones()
            //listaCanciones.remove(cancion)


        }
        fun modificarCancion(id:Int,nombre:String,autor:String,genero:String,acordes:String){
            putCancion(id,nombre,autor,genero,acordes)
            getCancion(id)
            //listaCanciones.set(posicion,cancion);
        }
        fun obtenerCancion(posicion: Int): Cancion? {
            getCancion(posicion)
            return cancion
        }


    }
}