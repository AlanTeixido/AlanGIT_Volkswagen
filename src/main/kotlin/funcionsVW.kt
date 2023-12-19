fun calcularPreuBase(normal:Boolean):Double{
    val preuBase: Double = when(normal){
        true -> 73490.0
        false -> 93490.0
    }
    return preuBase
}

fun calcularPreuActual(preuBase:Double):Double{
    val preuActual:Double=preuBase-preuBase*porcentajeFurgo()*readKM("Introduce los km de tu furgoneta: ",0)
    return  preuActual-depreciacionEstadoNeumaticos()
}