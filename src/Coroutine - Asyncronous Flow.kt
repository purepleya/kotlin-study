import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i * 10) // yield next value
    }
}

fun simpleFlow(): Flow<Int> = flow { // flow builder
    println("Flow started")

    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}


suspend fun performRequest(request: Int): String {
    delay(2000) // imitate long-running asynchronous work
    return "response $request"
}

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } catch (e: Exception) {
        println("Caught exception ${e.message}")
    } finally {
        println("Finally in numbers")
    }
}


fun main() {
//    simple().forEach { value -> println(value) }
    runBlocking {
//        launch {
//            for (k in 1..3) {
//                println("I'm not blocked $k")
//                delay(100)
//            }
//        }
//        simpleFlow().collect { value -> println(value) }

//        val flow = simpleFlow()
//        println("Calling simpleFlow...")
//        flow.collect { value -> println(value) }
//        println("Call collect again...")
//        flow.collect { value -> println(value) }
//
//        withTimeoutOrNull(250) {
//            simple().forEach { value -> println(value) }
//        }

//        (1..3).asFlow()
////            .map {request -> performRequest(request) }
//            .transform { request ->
//                emit("Making request $request")
//                emit(performRequest(request))
//            }
//            .collect { response -> println(response) }

        numbers()
            .take(2)
            .collect { println(it) }


    }

}
