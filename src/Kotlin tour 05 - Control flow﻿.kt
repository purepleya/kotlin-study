fun main() {
//    if
//    조건문을 사용할 때는 if, when 을 쓴다. 강력하고 안전한 처리를 위해 when을 추천한다.

//    if (조건식) {
//        ... // 조건식이 참일 때 수행할 코드
//    } else {
//        ... // 조건식이 거짓일 때 수행할 코드
//    }

    val value = 10

    if (value < 10) {
        println("value is less than 10")
    } else if (value == 10) {
        println("value is 10")
    } else {
        println("value is greater than 10")
    }

//    3항 연산자( 조건식 ? 참 : 거짓)는 없는 대신 if 문 자체를 표현식으로 사용 할 수 있다.
//    표현식으로 사용할 때는 {} 를 사용하지 않는다.
    println(if (value < 10) "value is less than 10" else "value is greater than or equal 10")


//    When
//    when 은 조건문이 복잡해질 때 사용한다. when 은 명령문이나 표현식으로 사용할 수 있다.

//    when (조건식) {
//        값1 -> 값 1 일때
//        값2 -> 값 2 일때
//        else -> else 일때
//    }

    val obj = "Hello"

    when (obj) {
//        위에서 부터 차례대로 비교하기 때문에 참 값 이후는 실행 되지 않는다.
        "1" -> println("One")
        "Hello" -> {
            println("Greeting")
            println("can execute multiple lines")
        }
//        Default statement
        else -> println("Unknown")
    }

//    아래처럼 표현식으로 사용할 수도 있고 표현식으로 사용할때는 else 를 꼭 사용해야 한다.
    val result = when (obj) {
        "1" -> "One"
        "Hello" -> {
            println("Greeting")
            println("can execute multiple lines")
            "Greeting"
        }
        else -> "Unknown"
    }
    println(result)


//    Ranges
//    반복문을 사용하기 위해 Range 를 사용할 수 있다.

    val range1 = 1..5 // 1, 2, 3, 4, 5
    val range2 = 1..<5 // 1, 2, 3, 4
    val range3 = 5 downTo 5 // 5, 4, 3, 2, 1
    val range4 = 5 downTo 1 step 2 // 5, 3, 1
    val range5 = 'a'..'d' // a, b, c, d

//    in 연산자를 이용 할 수 있다.
    val valueForRange: Int = 5;
    when (valueForRange) {
        in 1..5 -> println("in range 1 ~ 5")
        in 6..10 -> println("in range 6 ~ 10")
        else -> println("Unknown")
    }




}