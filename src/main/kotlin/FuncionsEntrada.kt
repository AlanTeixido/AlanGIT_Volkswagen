import java.util.Scanner

fun llegirInt(mensaje:String,intMin:Int,intMax:Int):Int{
    val scan=Scanner(System.`in`)
    var valorInt=0
    var valorCorrecto:Boolean
    do {
        print("$mensaje ")
        valorCorrecto=scan.hasNextInt()
        if (!valorCorrecto){
            println("ERROR: introduce un número entero")
        }else{
            valorInt=scan.nextInt()
            if (valorInt<intMin || valorInt>intMax){
                valorCorrecto=false
                println("ERROR: Introduce un número entre los valores requeridos")
            }
        }
        scan.nextLine()
    }while (!valorCorrecto)
    return valorInt
}

fun llegirLong(mensaje:String,intMin:Long,intMax:Long): Long {
    val scan=Scanner(System.`in`)
    var valorLong:Long=0
    var valorCorrecto:Boolean
    do {
        print("$mensaje ")
        valorCorrecto=scan.hasNextLong()
        if (!valorCorrecto){
            println("ERROR: introduce un número entero")
        }else{
            valorLong= scan.nextLong()
            if (valorLong<intMin || valorLong>intMax){
                valorCorrecto=false
                println("ERROR: Introduce un número entre los valores requeridos")
            }
        }
        scan.nextLine()
    }while (!valorCorrecto)
    return valorLong
}

fun llegirDouble(mensaje:String,intMin:Double,intMax:Double):Double{
    val scan=Scanner(System.`in`)
    var valorDouble=0.0
    var valorCorrecto:Boolean
    do {
        print("$mensaje ")
        valorCorrecto=scan.hasNextInt()
        if (!valorCorrecto){
            println("ERROR: introduce un número entero")
        }else{
            valorDouble=scan.nextDouble()
            if (valorDouble<intMin || valorDouble>intMax){
                valorCorrecto=false
                println("ERROR: Introduce un número entre los valores requeridos")
            }
        }
        scan.nextLine()
    }while (!valorCorrecto)
    return valorDouble
}