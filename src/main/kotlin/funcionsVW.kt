import org.example.BLUE
import org.example.GREEN
import org.example.PURPLE
import org.example.RESET

/**
 * Calcula el precio base de la furgoneta según la versión.
 *
 * @param normal Indica si la furgoneta es de versión normal (true) o versión Camper (false).
 * @return El precio base de la furgoneta.
 */
fun calcularPrecioBase(normal: Boolean): Double {
    return if (normal) {
        73490.0
    } else {
        93490.0
    }
}

/**
 * Calcula el precio actual de la furgoneta.
 *
 * @param precioBase El precio base de la furgoneta.
 * @return El precio actual de la furgoneta, considerando descuentos y depreciación.
 */
fun calcularPrecioActual(precioBase: Double): Double {
    // Se solicita al usuario ingresar los kilómetros totales recorridos por la furgoneta.
    val kmTotales = llegirLong(BLUE + "Introduce los km de tu furgoneta:" + RESET, 0)
    // Se muestra un mensaje indicando los kilómetros recorridos por la furgoneta.
    println(GREEN + "Tu furgoneta ha recorrido un total de $kmTotales km" + RESET)

    // Se calcula el porcentaje de descuento basado en los kilómetros totales recorridos.
    val porcentajeDescuento = porcentajeKM()
    // Se calcula la depreciación de los neumáticos.
    val depreciacion = depreciacionEstadoNeumaticos()

    // Se devuelve el precio actual restando descuentos y depreciación al precio base.
    return precioBase - precioBase * porcentajeDescuento * kmTotales - depreciacion
}
