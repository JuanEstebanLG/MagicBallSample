// Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "\uD83E\uDD14"

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)

fun main(args: Array<String>) {
    println("Hola!, Soy tu esfera magica, Dime, que deseas realizar.")
    println("1. Quiero Realizar una pregunta")
    println("2. Revisar todas las respeustas")
    println("3. Salir")

    val valorIng = readLine()

    when(valorIng){
        "1" -> realizarPregunta()
        "2" -> mostrarRespuestas()
        "3" -> leave()
        else -> mostrarError()
    }

}

fun mostrarError() {
    println("Ha ocurrido un Error :p, Intenta de nuevo.");
}

fun leave() {
    println("Hasta luego!")
}

fun mostrarRespuestas() {
    println("Selecciona una opcion:")
    println("1. Revisar todas las respuestas.")
    println("2. Revisar solo las respuestas Afirmativas")
    println("3. Revisar solo las respuestas Dudosas")
    println("4. revisar solo las repsuestas Negativas")
    val opcionIngresada = readLine()

    when(opcionIngresada){
        "1" -> mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
        "3" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        "4" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        else -> println("Respuesta no valida, Adios manco.")
    }

}

fun mostrarRespuestasPorTipo(tipoDeRespuesta : String = "TODOS") {
    when(tipoDeRespuesta){
        "TODOS" -> respuestas.keys.forEach {respuesta -> println(respuesta)}
        RESPUESTA_AFIRMATIVA -> respuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) };

        RESPUESTA_NEGATIVA -> respuestas.filterValues { values -> values == RESPUESTA_NEGATIVA }
            .also { respuestasN -> println(respuestasN.keys) }
        RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == RESPUESTA_DUDOSA }
            .also { respuestasIncongruentes -> println(respuestasIncongruentes.keys) }
    }
}

fun realizarPregunta(){
    println("¿Que deseas preguntar?")
    readLine()
    println("A si que era tu pregunta... Yo opino:")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}