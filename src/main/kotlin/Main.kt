fun leerLista():MutableList<Int>{

    var frames: Int = 1
    var tirada: Int = 0
    var control: Int = 1
    var anterior = 0

    val tiradas: MutableList<Int> = mutableListOf()


    while (frames <= 10) {

        tirada = readLine()!!.toInt()
        tiradas.add(tirada)
        when{
            tirada == 10 && frames == 10 && control == 2 || tirada + anterior == 10 && frames == 10 && control == 2 ->  {
                tirada = readLine()!!.toInt()
                tiradas.add(tirada)
                frames++
                control = 1
            }
            tirada == 10 && frames == 10 && control == 1 -> {
                tirada = readLine()!!.toInt()
                tiradas.add(tirada)
                tirada = readLine()!!.toInt()
                tiradas.add(tirada)
                frames++
                control = 2
            }
            tirada == 10 && control == 1 -> {
                frames++
                control = 1
            }
            else ->{
                when (control) {
                    2-> {
                        frames++;
                        control = 1
                    }
                    1-> control = 2

                }
            }
        }


        anterior = tirada
    }

    return tiradas
}

fun calcularPuntaje(tiradas:MutableList<Int>):Int{

    var indice = 0
    var puntaje = 0
    var it = 1

    while (it <= 10) {
        var t1 = tiradas.get(indice)
        var t2 = tiradas.get(indice + 1)
        when {
            t1==10->{
                puntaje+=10+tiradas.get(indice+1)+tiradas.get(indice+2)
                it++
                indice+=1

            }
            t2 == 10 -> {
                puntaje += 10
                puntaje += tiradas.get(indice + 2)
                it++
                indice += 2
            }

            t1 != 10 -> {
                puntaje += t1 + t2
                if (t1 + t2 == 10) {
                    puntaje += tiradas.get(indice + 2)
                }
                it++
                indice += 2
            }


            else -> {
                when {
                    tiradas.get(indice + 2) == 10 -> puntaje += 10
                    else -> {
                        puntaje += tiradas.get(indice + 1) + tiradas.get(indice + 2)
                    }
                }
                puntaje += 10
                it++
                indice += 1
            }
        }
    }

    return puntaje
}

fun main(args: Array<String>) {

    try {
        println(calcularPuntaje(leerLista()))
    }catch (e: NumberFormatException){
        println("Ingresa digito por digito")
    }

    
}



