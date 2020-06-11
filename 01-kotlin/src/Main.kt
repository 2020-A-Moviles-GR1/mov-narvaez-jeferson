import java.util.*

fun main(args:Array<String>){
    print("Hola");
   var edad=31;

    var edadProfesor=31; //NO SE PUEDE REASIGNAR
    var numero:Int;     //SE PUEDE REASIGNAR
    //Tipos de variables
    val nombreProfesor:String="Vicente Adrian";
    val sueldo:Double=12.20
    val inicialProfesor:Char='V';
    val fechaNacimiento:Date =Date(); //Instanciar una clase
    // when en vez de Switch
    when(sueldo){
        12.20-> { return print("sueldo normal")}
        -12.20-> print("Sueldo negativo")
        else -> println("No se reconoce el sueldo")
    }
    //IF de una linea como el operador ternario
    val esSueldoMayorAlEstablecido= if(sueldo==12.20) true else false
    calcularSueldo(29.00)
    //Puedo poner en otro orden las variables al llamar a la funcion
    calcularSueldo(tasa=14.00,sueldo = 4.00)
}
 // OJO ESTE OPCIONAL NO ES COMO EL DE TYPESCRIPT DELEY HAY QUE MANDAR COMO PARAMETRO PERO PUEDE SER NULL
fun calcularSueldo(sueldo:Double,tasa:Double=12.00,opcion:Int?=null): Double {
    if(opcion!=null){
        return sueldo*tasa*opcion;
    }else{
        return sueldo*tasa
    }
}
//Unit es como void
fun imprimirMensaje():Unit{
    print("")
}
