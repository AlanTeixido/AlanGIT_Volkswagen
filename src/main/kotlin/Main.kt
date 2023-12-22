import org.example.*

fun main(){
    menu()
    val normalOCamper:Boolean = pedirVersionFurgo()
    val suma250:Boolean = pedirTienePortaBicis()
    val sumaYa250:Int
    if (suma250) sumaYa250=250
    else sumaYa250=0
    val precioBase=calcularPreuBase(normalOCamper)+sumaYa250
    val precioActual=calcularPreuActual(calcularPreuBase(normalOCamper))+sumaYa250
    println(BLACK_BOLD+ WHITE_UNDERLINED +"El precio base de tu furgoneta es: "+precioBase+"€"+RESET)
    println(BLACK_BOLD+ WHITE_UNDERLINED +"El precio actual de tu furgoneta es: "+precioActual+"€"+ RESET)
}

fun menu(){
    println("Bienvenido al mercado de vehículos")

}

fun pedirVersionFurgo():Boolean{
    println(CYAN+"¿Tu furgoneta es la versión normal (true) o la versión Camper (false)?"+RESET)
    var versionFurgo= readBoolean(BLUE+"Introduce la versión de tu furgoneta:"+RESET, RED +"introduce true/false" + RESET)
    if (versionFurgo){
        println(PURPLE+"Tienes la furgoneta normal"+RESET)
    }else{
        println(PURPLE+"Tienes la versión Camper"+RESET)
    }
    return versionFurgo
}

fun pedirTienePortaBicis():Boolean{
    var portaBicis=readBoolean(BLUE+"¿Tiene portabicis tu furgoneta?:"+RESET,"introduce true/false")
    if (portaBicis) println(PURPLE+"Tu furgoneta tiene portabicis"+RESET)
    else println(PURPLE+"Tu furgoneta no tiene portabicis"+RESET)
    return portaBicis
}

fun depreciacionEstadoNeumaticos():Int{
    var estadoNeumaticos=llegirLong(BLUE+"Introduce los km recorridos con los neumáticos acutales:"+RESET,0)
    println(PURPLE+"Los neumáticos actuales de tu furgoneta han reccorrido "+estadoNeumaticos+"km"+RESET)
    var depreciacion:Int
    if (estadoNeumaticos<5000){
        depreciacion=0
    }else if (estadoNeumaticos>=5000 && estadoNeumaticos<10000){
        depreciacion=200
    }else{
        depreciacion=300
    }
    return depreciacion
}

fun porcentajeKM():Double{
    var porcentaje:Double
    var anosFurgo=llegirInt(BLUE+"Introduce los años de tu furgoneta:"+RESET,0,100)
    println(PURPLE+"Tu furgoneta lleva matriculada "+anosFurgo+" años"+RESET)
    if (anosFurgo<6) porcentaje=0.00001
    else if (anosFurgo>=6 && anosFurgo<10) porcentaje=0.00002
    else porcentaje=0.00004
    return porcentaje
}
