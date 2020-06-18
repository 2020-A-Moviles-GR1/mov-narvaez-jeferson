import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import java.util.function.Consumer
import kotlin.collections.ArrayList

fun main(args:Array<String>) {
    print("Hola");
    var edad = 31;

    var edadProfesor = 31; //NO SE PUEDE REASIGNAR
    var numero: Int;     //SE PUEDE REASIGNAR
    //Tipos de variables
    val nombreProfesor: String = "Vicente Adrian";
    val sueldo: Double = 12.20
    val inicialProfesor: Char = 'V';
    val fechaNacimiento: Date = Date(); //Instanciar una clase
    // when en vez de Switch

    when (sueldo) {
        12.20 -> print("\nsueldo normal")
        -12.20 -> print("Sueldo negativo")
        else -> println("No se reconoce el sueldo")
    }
    //IF de una linea como el operador ternario
    // val esSueldoMayorAlEstablecido= if(sueldo==12.20) true else false

    calcularSueldo(29.00)
    //Puedo poner en otro orden las variables al llamar a la funcion
    calcularSueldo(tasa = 14.00, sueldo = 4.00)
    val arregloConstante: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    //los arreglos constantes no tienen metodos para añadir elementos
    val arregloCumpleanos: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    print(arregloCumpleanos);
    arregloCumpleanos.add(100);
    print(arregloCumpleanos)
    arregloCumpleanos.remove(100)
    println(arregloCumpleanos)
//FOR EACH RETORNA Unit
    arregloCumpleanos.forEach { println("Valor de la iteracion " + it); }
    arregloCumpleanos.forEach { fecha: Int -> println("Valor de la iteracion " + fecha); }
    arregloCumpleanos.forEach(Consumer { fecha: Int? -> println("Valor interacion " + fecha) })
    val respuestaMap = arregloCumpleanos.map({ x ->
        val y = x * -1 //AQUI PONER TODAS LAS OPERACIONES
        return@map y
    })

    println(respuestaMap)
    val respuestaMap2 = arregloCumpleanos.map({ x -> x * -1 })
    println(respuestaMap2)

    val respuestaFilter = arregloCumpleanos.filter { x -> x > 5 }
    println(respuestaFilter)

    //Compara si algun elemento cumple la condicion
    val respuestaAny: Boolean = arregloCumpleanos.any { value: Int -> value < 1 }
    println(respuestaAny)
    //Compara si es que todos los elementos complen la cndicion
    val respuestaAll: Boolean = arregloCumpleanos.all { value: Int -> value < 5 }
    println((respuestaAll))
//Reduce devuelve la suma de los elemento
//el acumulador siempre empieza en vacio
    val respuestaReduce: Int = arregloCumpleanos.reduce { acc, i -> acc + i }
    println(respuestaReduce);
 //Restar iteraciones desde una semilla
    val respuestaFold:Int = arregloCumpleanos.fold(200,{acc,i -> acc-i});
    print(respuestaFold);

}
 // OJO ESTE OPCIONAL NO ES COMO EL DE TYPESCRIPT DELEY HAY QUE MANDAR COMO PARAMETRO PERO PUEDE SER NULL
fun calcularSueldo(sueldo:Double,tasa:Double=12.00,opcion:Int?=null): Double? {
     print("Calculando sueldo")
    if(opcion!=null){
        return sueldo*tasa*opcion;
    }else{
        return sueldo*tasa
    }
}
//Unit es como void
fun imprimirMensaje():Unit{
    print("hola mundo"  );
}
