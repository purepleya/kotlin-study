import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


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

        val flow = simpleFlow()
        println("Calling simpleFlow...")
        flow.collect { value -> println(value) }
        println("Call collect again...")
        flow.collect { value -> println(value) }

        withTimeoutOrNull(250) {
            simple().forEach { value -> println(value) }
        }
    }


}