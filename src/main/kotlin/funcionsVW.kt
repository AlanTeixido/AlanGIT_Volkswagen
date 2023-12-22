import org.example.BLUE
import org.example.PURPLE
import org.example.RESET

fun calcularPreuBase(normal:Boolean):Double{
    val preuBase: Double = when(normal){
        true -> 73490.0
        false -> 93490.0
    }
    return preuBase
}

fun calcularPreuActual(preuBase:Double):Double{
    val kmTotales=llegirLong(BLUE+"Introduce los km de tu furgoneta:"+ RESET,0)
    println(PURPLE+"Tu furgoneta ha recorrido un total de "+kmTotales+"km"+RESET)
    val preuActual:Double=preuBase-preuBase*porcentajeKM()*kmTotales
    return  preuActual-depreciacionEstadoNeumaticos()
}
