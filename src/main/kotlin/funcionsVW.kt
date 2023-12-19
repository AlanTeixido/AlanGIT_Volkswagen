fun calcularPreuBase(normalOCamper: Boolean): Double {
    var precioBase = 20000.0 // Precio base inicial, puedes ajustarlo según tus necesidades

    // Lógica para la versión Camper
    if (!normalOCamper) {
        precioBase += 5000.0 // Sumar 5000€ al precio base si es Camper
    }

    // Lógica para el portabicis
    val precioPortabicis = portabicis()
    precioBase += precioPortabicis.toDouble()

    // Lógica para el porcentaje de la furgoneta
    val porcentaje = porcentajeFurgo()
    precioBase -= precioBase * porcentaje

    return precioBase
}

fun calcularPreuActual(preuBase: Double): Double {
    val porcentajeDepreciacion = porcentajeFurgo()
    val kmRecorridos = readKM("Introduce los km de tu furgoneta: ", 0)

    // Calcular el precio actual antes de la depreciación de los neumáticos
    var preuActual: Double = preuBase - preuBase * porcentajeDepreciacion * kmRecorridos

    // Aplicar depreciación por el estado de los neumáticos
    preuActual -= depreciacionEstadoNeumaticos()

    return preuActual
}