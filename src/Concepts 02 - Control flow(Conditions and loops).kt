fun main(args: Array<String>) {
//    ifExpression()
//    ifExpression2()
//    whenExpression()
//    whenExpression5()
//    basicForSyntex()
//    forArray()
    whileLoop()
}

fun ifExpression() {
    println("If Expression ======================")
    val a = 5
    val b = 10

    var max = a
    if (a < b) max = b
    println("Max value is $max")

    if (a > b) {
        max = a
    } else {
        max = b
    }
    println("Max value is $max")

    // 표현 식 으로서의 if
    max = if (a > b) a else b
    println("Max value is $max")

    // else if도 표현식 으로 사용 가능
    val maxLimit = 1
    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b
    println("Max value is $maxOrLimit")

    println("")
}


fun ifExpression2() {
    val a = 5
    val b = 10

    // else 문이 없는 경우 에러가 발생한다.
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    println("Max value is $max")
}


fun whenExpression() {
    val x = 2

    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }
}


enum class Bit {
    ZERO, ONE
}
fun whenExpression2() {
    val b: Bit = Bit.ONE

    val numericValue = when (b) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        // 모든 경우를 커버하기 때문에 else가 필요 없다.
    }

    val isZero = when (b) {
        Bit.ZERO -> true
        else -> false // 모든 경우를 커버지 않는경우 enum 타입이라도 else가 필요하다.
    }

    val isOverZero = when (numericValue) {
        0 -> false
        1 -> true
        else -> true // else 가 없으면 에러가 발생한다.
    }
}

fun whenExpression3() {
    val x = 2
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
}

fun whenExpression4() {
    val s = "2"
    val x = 2

    when (x) {
        s.toInt() -> print("s encodes x")
        else -> print("s does not encode x")
    }
}

fun whenExpression5() {
    val x = 2
    when (x) {
        in 1..10 -> print("x is in the range")
        !in 10 ..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
//    x is in the range
}

fun whenExpression6(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}

//fun Request.getBody() = when (val response = executeRequest()) {
//    is Success -> response.body
//    is HttpError -> throw HttpException(response.status)
//}

fun basicForSyntex() {
    val items = listOf("apple", "banana", "kiwi")

    for (item in items) println(item)

    // 코드 부분을 블록으로 감싸서 사용할 수 있다.
    for (item in items) {
        println("item is $item")
    }
}


fun forArray() {
    val items = listOf("apple", "banana", "kiwi")

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    for ((index, value) in items.withIndex()) {
        println("the element at $index is $value")
    }
}

fun whileLoop() {
val items = listOf("apple", "banana", "kiwi")

var index = 0
while (index < items.size) {
    println("item at $index is ${items[index]}")
    index++
}

var executeCount = 1
do {
    println("this is ${executeCount}th do-while loop")
    executeCount++
} while (executeCount < 2)
}