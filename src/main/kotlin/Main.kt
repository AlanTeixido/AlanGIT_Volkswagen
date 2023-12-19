import org.example.readBoolean
import java.util.Scanner

fun main() {
    menu()
    var normalOCamper: Boolean
    if (pedirVersionFurgo()) normalOCamper = true
    else normalOCamper = false
    var precioBase = calcularPreuBase(normalOCamper)
    var precioActual = calcularPreuActual(calcularPreuBase(normalOCamper))
    println("El precio base de tu furgoneta es: " + precioBase + "€")
    println("El precio actual de tu furgoneta es: " + precioActual + "€")
}

fun pedirVersionFurgo(): Boolean {
    println("¿Tu furgoneta es la versión normal (true) o la versión Camper (false)?")
    var versionFurgo = readBoolean("Introduce la versión de tu furgoneta", "introduce true/false")
    if (versionFurgo) {
        println("Tienes la furgoneta normal")
    } else {
        println("Tienes la versión Camper")
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
            println("ERROR: introduce un número entero")
        } else {
            intValue = scanner.nextInt()
            if (intValue < kmMin) {
                println("ERROR: el valor introducido debe ser mayor a 0")
                correctValue = false
            }
        }
        scanner.nextLine()
    } while (!correctValue)
    return intValue
}

fun menu() {
    println("Bienvenido al mercado de vehículos")
}

fun depreciacionEstadoNeumaticos(): Int {
    val estadoNeumaticos = llegirInt("Introduce los km recorridos con los neumáticos acutales:", 0, 500000)
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
    val portabicis = readBoolean("Tiene portabicis?", "Incorrecte")
    val suma250: Int

    if (portabicis) suma250 = 250
    else suma250 = 0

    return suma250
}

fun porcentajeFurgo(): Double {

    val porcentaje: Double

    val añosfurgo = llegirDouble("Introduce los años de tu furgoneta", 0.0, 100.0)

    if (añosfurgo < 6) porcentaje = 0.0001
    else if (añosfurgo < 10) porcentaje = 0.0002
    else porcentaje = 0.0004

    return porcentaje
}