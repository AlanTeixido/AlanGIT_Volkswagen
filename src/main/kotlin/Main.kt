import org.example.*
import java.util.Scanner

fun main() {
    menu()
    var normalOCamper: Boolean
    if (pedirVersionFurgo()) normalOCamper = true
    else normalOCamper = false
    var precioBase = calcularPreuBase(normalOCamper)
    var precioActual = calcularPreuActual(calcularPreuBase(normalOCamper))
    println("${BLUE}El precio base de tu furgoneta es: $precioBase€${RESET}")
    println("${BLUE}El precio actual de tu furgoneta es: $precioActual€${RESET}")
}

fun pedirVersionFurgo(): Boolean {
    println("${PURPLE}¿Tu furgoneta es la versión normal (true) o la versión Camper (false)?${RESET}")
    var versionFurgo = readBoolean("${GREEN}Introduce la versión de tu furgoneta${RESET}", "${RED}Introduce true/false${RESET}")
    if (versionFurgo) {
        println("${GREEN}Tienes la furgoneta normal${RESET}")
    } else {
        println("${GREEN}Tienes la versión Camper${RESET}")
    }
    return versionFurgo
}


fun readKM(message: String, kmMin: Int): Int {
    val scanner = Scanner(System.`in`)
    var intValue = 0
    var correctValue: Boolean
    do {
        print(message)
        correctValue = scanner.hasNextInt()
        if (!correctValue) {
            println("${RED}ERROR: Introduce un número entero${RESET}")
        } else {
            intValue = scanner.nextInt()
            if (intValue < kmMin) {
                println("${RED}ERROR: El valor introducido debe ser mayor a 0${RESET}")
                correctValue = false
            }
        }
        scanner.nextLine()
    } while (!correctValue)
    return intValue
}
fun menu() {
    println("${BLUE_BACKGROUND}Bienvenido al mercado de vehículos${RESET}")
}
fun depreciacionEstadoNeumaticos(): Int {
    val estadoNeumaticos = llegirInt("${GREEN}Introduce los km recorridos con los neumáticos actuales: ${RESET}", 0, 500000)
    val depreciacion: Int
    if (estadoNeumaticos < 5000) {
        depreciacion = 0
    } else if (estadoNeumaticos >= 5000 && estadoNeumaticos < 10000) {
        depreciacion = 200
    } else {
        depreciacion = 300
    }
    return depreciacion
}

fun portabicis(): Int {
    val portabicisString = readLine()?.toBoolean() ?: false
    return if (portabicisString) 250 else 0
}


fun porcentajeFurgo(): Double {
    val añosfurgo = llegirDouble("${GREEN}Introduce los años de tu furgoneta${RESET}", 0.0, 100.0)
    val porcentaje: Double = when {
        añosfurgo < 6 -> 0.0001
        añosfurgo < 10 -> 0.0002
        else -> 0.0004
    }
    return porcentaje
}