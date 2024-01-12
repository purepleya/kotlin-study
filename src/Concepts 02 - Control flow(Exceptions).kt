fun main() {
//    exceptionDemo1()
    nothingTypeDemo()
}


@Throws(ArithmeticException::class)
fun exceptionDemo1() {
    val a = 5
    val b = 0

    // catch나 finally 블록이 없어서 컴파일 오류 발생
//    try {
//        println(a / b)
//    }

    // catch 블록만 작성
    try {
        println(a / b)
    } catch (e: Exception) {
        println("Exception")
    }
    // Exception


    // finally 블록만 작성, 예외 처리가 되지 않아 예외를 발생시킨다.
    try {
        println(a / b)
    } finally {
        println("finally")
    }
    // 예외 발생


    // catch와 finally 블록을 모두 작성
    try {
        println(a / b)
    } catch (e: Exception) {
        println("Exception")
    } finally {
        println("finally")
    }
    // Exception
    // finally


    // 발생하는 예외마다 예외 처리를 다르게 할 수 있다.
    try {
        println(a / b)
    } catch (e1: ArithmeticException) {
        println("This is ArithmeticException")
    } catch (e: Exception) {
        println("Exception")
    }
    // This is ArithmeticException
}



fun parseIntElseZero(s: String): Int {
    val a: Int = try {
        s.toInt()
    } catch (e: Exception) {
        0
    }

    return a
}

fun nothingTypeDemo() {
    val a: String? = null
    val b = a ?: throw IllegalArgumentException("a must not be null")
    println(b)
}