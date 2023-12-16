// 함수는 fun 키워드를 이용해서 정의 한다.

//1. 파라미터는 ()괄호 안에 작성한다.
//2. 파라미터는 타입을 명시해야 하고, 복수의 파라미터는 콤마로 구분한다.
//3. 함수의 반환 타입은 파라미터와 함수의 ()괄호 다음에 콜론(:)을 넣고 그 뒤에 작성한다.
//4. 함수의 본문은 {} 괄호 안에 작성한다.
//5. 함수의 종료나 어떤 값을 반환하기 위해서 return 키워드를 사용한다.


fun sum(x: Int, y: Int): Int {
    return x + y
}

//Named arguments
//함수를 호출할때 파라미터의 이름을 명시 함으로서 파라미터의 순서를 바꾸거나, 가독성을 향상 시킬 수 있다.
fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}

//Default parameter values
//함수를 정의 할때 매개변수의 기본 값을 정의 할 수 있다. 기본 값이 정의된 매개변수는 함수를 호출 할 때 생략 할 수 있다.
fun printMessageWithPrefixDefaultParameter(message: String, prefix: String = "Info") {
    println("DefaultParameter - [$prefix] $message")
}

//Return 없는 함수
//return 이 없는 함수의 경우 명시적으로 반환 타입을 Unit 으로 정의 할 수 있다. Unit 은 Java 의 void 와 같다.
fun printMessage(message: String): Unit {
    println("print message - $message")
//    return Unit 또는 return 생략 가능
}

// Single-expression functions
// 함수의 본문이 한줄인 경우 {} 를 생략 할 수 있다.

//fun sum(x: Int, y: Int): Int {
//    return x + y
//}
// 위 함수를 아래 처럼 사용 할 수 있다.
fun sumSingleExpression(x: Int, y: Int): Int = x + y

// Lambda expressions
// 람다식은 {}괄호 안에 작성한다.
// "파라미터 -> 함수 본문" 형태로 작성한다.
fun printWithLambda(message: String) {
//    string: String -> string.uppercase()
    println({string: String -> string.uppercase()}(message));
}

// 1. 람다식은 변수에 할당해서 나중에 실행 할 수 있다.
fun lambdaAssignToVariable() {
    var upperCaseString = {string: String -> string.uppercase()}
    println(upperCaseString("Hello Lambda"))
}
// 2. 다른 함수의 매개변수로 람다식을 전달 할 수 있다.
fun lambdaPassToAnotherFunction() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }
    println(positives)
    val negatives = numbers.filter { x -> x < 0 }
    println(negatives)
}
// 3. 함수의 반환 값으로 람다식을 사용 할 수 있다.
// 컴파일러가 함수의 반환 타입에 대해 알고 있어야 한다. 따라서 함수의 반환 타입을 함수 타입으로 정의 해야 한다.
// 함수 타입은 "(파라미터1 타입, 파라미터2 타입, ...) -> 반환 타입" 형태로 정의한다.
// 파라미터가 없다면 빈 괄호() 를 사용하고 반환 타입이 없다면 Unit 을 사용한다.
fun toSeconds(time: String): (Int) -> Int {
    return when(time) {
        "hour" -> { value -> value * 60 * 60 }
        "minute" -> { value -> value * 60 }
        "second" -> { value -> value }
        else -> { value -> value }
    }
}

fun lambdaReturn() {
    val hourToSeconds = toSeconds("hour")
    println(hourToSeconds(1))
    val minuteToSeconds = toSeconds("minute")
    println(minuteToSeconds(1))
    val secondToSeconds = toSeconds("second")
    println(secondToSeconds(1))

//    응용
    val timesInMinute = listOf(1, 2, 3, 4, 5)
    val timesInSecond = timesInMinute.map(minuteToSeconds)
    val totalTimeInSecond = timesInSecond.sum()
    println("Total Second of $timesInMinute : $totalTimeInSecond")
}

// 4. 람다식 자체를 실행 할 수 있다.
fun lambdaInvoke() {
//    선언과 동시에 실행
    println({string: String -> string.uppercase()}("Hello Lambda"))
}

//Trailing lambda
// 람다식이 함수의 유일한 파라미터 이거나, 마지막 파라미터라면 () 괄호 밖으로 빼낼 수 있다.
//println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 이렇게 작성하는 것을
//println(listOf(1, 2, 3).fold(0) { x, item -> x + item }) // 이렇게 작성가능하다.


fun main() {
    println(sum(3, 5))

    printMessageWithPrefix(prefix = "Log", message = "Hello")

    printMessageWithPrefixDefaultParameter("Hello")
    printMessageWithPrefixDefaultParameter("Hello", "Warn")

    printMessage("Hello")

    println("sumSingleExpression - ${sumSingleExpression(3, 5)}")

    printWithLambda("Hello Lambda")


}

