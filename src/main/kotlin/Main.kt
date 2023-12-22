import org.example.*

/**
 * Función principal que ejecuta el programa.
 */
fun main() {
    mostrarAsciiArt()
    menu()
    val versionNormal = pedirVersionFurgo()
    val tienePortaBicis = pedirTienePortaBicis()

    // Calcula el precio base sumando 250 si tiene portabicis.
    val precioBase = calcularPrecioBase(versionNormal) + if (tienePortaBicis) 250 else 0

    // Calcula el precio actual sumando 250 si tiene portabicis.
    val precioActual = calcularPrecioActual(calcularPrecioBase(versionNormal)) + if (tienePortaBicis) 250 else 0

    println(BLACK_BOLD + WHITE_UNDERLINED + "El precio base de tu furgoneta es: $precioBase €" + RESET)
    println(BLACK_BOLD + WHITE_UNDERLINED + "El precio actual de tu furgoneta es: $precioActual €" + RESET)
}

/**
 * Muestra un arte ASCII en la consola.
 * Este arte ASCII es un ejemplo y puede personalizarse según las preferencias.
 */
fun mostrarAsciiArt() {
    println(
        """
                                                         _________________________   
                    /\\      _____          _____       |   |     |     |    | |  \  
     ,-----,       /  \\____/__|__\_    ___/__|__\___   |___|_____|_____|____|_|___\ 
  ,--'---:---`--, /  |  _     |     `| |      |      `| |                    | |    \
 ==(o)-----(o)==J    `(o)-------(o)=   `(o)------(o)'   `--(o)(o)--------------(o)--'  
````````````````````````````~~````````````````````````````````````````````````````
    """
    )
}

/**
 * Muestra un mensaje de bienvenida en la consola.
 */
fun menu() {
    println("Bienvenido al mercado de vehículos")
}

/**
 * Pide al usuario la versión de la furgoneta (normal o Camper) y devuelve un booleano.
 *
 * @return true si la furgoneta es la versión normal, false si es la versión Camper.
 */
fun pedirVersionFurgo(): Boolean {
    println(CYAN + "¿Tu furgoneta es la versión normal (true) o la versión Camper (false)?"+RESET)
    var versionFurgo = readBoolean(BLUE + "Introduce la versión de tu furgoneta:" + RESET, RED + "introduce true/false" + RESET)

    // Muestra un mensaje indicando la versión de la furgoneta.
    if (versionFurgo) {
        println(GREEN + "Tienes la furgoneta normal" + RESET)
    } else {
        println(GREEN + "Tienes la versión Camper" + RESET)
    }
    return versionFurgo
}

/**
 * Pide al usuario si la furgoneta tiene portabicis y devuelve un booleano.
 *
 * @return true si la furgoneta tiene portabicis, false si no.
 */
fun pedirTienePortaBicis(): Boolean {
    var portaBicis = readBoolean(BLUE + "¿Tiene portabicis tu furgoneta?:" + RESET, RED + "introduce true/false" + RESET)

    // Muestra un mensaje indicando si la furgoneta tiene portabicis o no.
    if (portaBicis) println(GREEN + "Tu furgoneta tiene portabicis" + RESET)
    else println(GREEN + "Tu furgoneta no tiene portabicis" + RESET)
    return portaBicis
}

/**
 * Pide al usuario los kilómetros recorridos con los neumáticos actuales y devuelve la depreciación correspondiente.
 *
 * @return La depreciación de los neumáticos.
 */
fun depreciacionEstadoNeumaticos(): Int {
    var estadoNeumaticos = llegirLong(BLUE + "Introduce los km recorridos con los neumáticos acutales:" + RESET, 0)

    // Muestra un mensaje indicando los kilómetros recorridos por los neumáticos.
    println(GREEN + "Los neumáticos actuales de tu furgoneta han recorrido $estadoNeumaticos km" + RESET)

    var depreciacion: Int
    if (estadoNeumaticos < 5000) {
        depreciacion = 0
    } else if (estadoNeumaticos >= 5000 && estadoNeumaticos < 10000) {
        depreciacion = 200
    } else {
        depreciacion = 300
    }
    return depreciacion
}

/**
 * Pide al usuario los años de la furgoneta y devuelve el porcentaje correspondiente.
 *
 * @return El porcentaje de descuento basado en los años de la furgoneta.
 */
fun porcentajeKM(): Double {
    var porcentaje: Double
    var anosFurgo = llegirInt(BLUE + "Introduce los años de tu furgoneta:" + RESET, 0, 100)

    // Muestra un mensaje indicando los años matriculados de la furgoneta.
    println(GREEN + "Tu furgoneta lleva matriculada $anosFurgo años" + RESET)

    if (anosFurgo < 6) porcentaje = 0.00001
    else if (anosFurgo >= 6 && anosFurgo < 10) porcentaje = 0.00002
    else porcentaje = 0.00004
    return porcentaje
}
