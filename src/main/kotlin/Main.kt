package org.example

import java.util.Scanner

fun main() {
    val model = demanarModel()
    val estatPneumatics = demanarEstatPneumatics()

    val preuBase = calcularPreuBase(model)
    val preuActual = calcularPreuActual(preuBase, estatPneumatics)

    println("Preu base original de la furgo: $preuBase €")
    println("Preu actual de la furgo: $preuActual €")
}

fun demanarModel(): String {
    val scanner = Scanner(System.`in`)
    println("Té la Volkswagen Grand California 'normal' o la Camper Full Equip? (normal/camper)")
    return scanner.nextLine().toLowerCase()
}

fun demanarEstatPneumatics(): Int {
    val scanner = Scanner(System.`in`)
    println("Quants quilòmetres tenen els pneumàtics?")
    return readInt(scanner)
}

fun calcularPreuBase(model: String): Int {
    return when (model) {
        "normal" -> 73490
        "camper" -> 93490
        else -> {
            println("Model no vàlid. S'usarà el preu base de la versió normal.")
            73490
        }
    }
}

fun calcularPreuActual(preuBase: Int, estatPneumatics: Int): Int {
    val depreciacio = 0.00001
    val depreciacioPneumatics = when {
        estatPneumatics < 5000 -> 0
        estatPneumatics < 10000 -> 200
        else -> 300
    }

    val depreciacioTotal = (preuBase * depreciacio * estatPneumatics).toInt() + depreciacioPneumatics
    return preuBase - depreciacioTotal
}

fun readInt(scanner: Scanner): Int {
    var valor: Int = 0
    var correctType: Boolean

    do {
        correctType = scanner.hasNextInt()

        if (!correctType) {
            println("ERROR: Siusplau, introdueix un número vàlid.")
        } else {
            valor = scanner.nextInt()
            scanner.nextLine()
        }

    } while (!correctType)

    return valor
}