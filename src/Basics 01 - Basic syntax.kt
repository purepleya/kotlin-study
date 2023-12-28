// package 정의와 import
package my.demo
// package 정의는 소스파일 맨 위에 위치 해야 하며
// 디렉토리 구조와 일치할 필요는 없다. (소스파일은 아무곳에나 위치 해도 된다.)

// Program 진입 점
// Kotlin 어플리케이션의 진입점은 main 함수이다.
// main 함수의 파라미터(args: Array<String>)는 선택사항이다.

fun main(args: Array<String>) {
    println("Hello, World!")

    // print 함수는 전달인자(argument)를 표준 출력으로 출력한다.
    print("Hello ")
    print("World!")

    // println 함수는 전달인자(argument)를 표준 출력으로 출력하고
    // 마지막에 개행 문자를 출력한다.
    println("Hello world!")
    println(42)
}

// 함수
// Int 파라미터 2개를 받아서 Int를 리턴하는 함수
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 함수의 본문을 표현식으로 대체할 수 있다. 리턴 타입은 추론된다.
fun sum2(a: Int, b: Int) = a + b

// 리턴이 없는 함수는 리턴타입을 Unit으로 명시하던지, 생략 할 수 있다.
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

// 변수
// readonly 지역 변수는 val 키워드를 이용해 선언한다. 한번 값이 할당되면 재 할당 될 수 없다.
fun variablesWithVal() {
    val a: Int = 1 // 즉시 할당
    val b = 2 // Int 타입 추론
    val c: Int // 초기화 없이 선언
    c = 3 // 나중에 할당
    println("a = $a, b = $b, c = $c")
}

// mutable 지역 변수는 var 키워드를 이용해 선언한다.
fun variablesWithVar() {
    var x = 5 // Int 타입 추론
    x += 1
    println("x = $x")
}

// 변수를 최상위에 정의하고 사용 할 수 있다.
var x = 0
fun incrementX() {
    x += 1
}


// class 선언과 인스턴스 만들기
// 클래스 선언은 class 키워드로 시작한다.
// 속성 들은 클래스 선언 부나 본문에 작성 된다.
class Rectangle(val height: Int, var width: Int) {
    val perimeter = (height + width) * 2
}

// 클래스 선언부에 선언된 속성들은 인스턴스의 속성으로 사용가능 하다.
fun rectangle() {
    val rectangle = Rectangle(5, 2)
    println("rectangle height: ${rectangle.height}")
    println("rectangle width: ${rectangle.width}")
    println("rectangle perimeter: ${rectangle.perimeter}")
}

// class 는 기본적으로 final 로 정의 되기 때문에 상속이 불가능하다.
// 상속을 허용하려면 open 키워드를 붙여야 한다.
open class Shape(val name: String) {
    open fun area() = 0.0
}

// 상속을 받으려면 클래스 이름 뒤에 콜론(:)을 붙이고 상속 받을 클래스를 적는다.
class Rectangle2(val height: Double, val width: Double) : Shape("Rectangle") {
    // override 키워드를 붙여서 부모 클래스의 메소드를 오버라이드 할 수 있다.
    override fun area() = height * width
}


// 주석
// 한줄 주석

/*
    여러줄 주석
    여러줄 주석
*/

/*
    /*
        중첩 주석
     */

     // 중첩 주석
 */


// String templates
// 문자 열 안에서 "$변수" 형태나 "${표현식}" 형태로 사용 할 수 있다.
// "a is $a"
// "${s1.replace("is", "was")}, but now is $a"


// 조건문
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
// 아래처럼 표현식으로 사용 할 수도 있다.
fun maxOf2(a: Int, b: Int) = if (a > b) a else b



// for loop
fun forLoop() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    for (num in 1..3) {
        println(num)
    }
}


// while loop
fun whileLoop() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

// when expression
fun describe(obj: Any): String =
    when (obj) {
        1           -> "One"
        "Hello"     -> "Greeting"
        is Long     -> "Long"
        !is String  -> "Not a string"
        else        -> "Unknown"
    }


// Range
// range 선언은 1..5 와 같이 .. 연산자를 사용한다. 이는 1, 2, 3, 4, 5 를 포함한다.
// range 는 in 연산자와 함께 사용 할 수 있다.
fun range() {
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }

    // !in (not in) 연산자를 사용해서 범위에 포함되지 않는지 검사 할 수 있다.
    if (x !in 1..y+1) {
        println("out of range")
    }

//    step을 이용해서 증가폭을 지정하거나, downTo 로 감소 시킬 수 있다.
//    1..10 step 2 = [1, 3, 5, 7, 9]
//    9 downTo 0 step 3 = [9, 6, 3, 0]
}


// Collections
fun collections() {
    val items = listOf("apple", "banana", "kiwi")

    // for 문으로 컬렉션을 순회 할 수 있다.
    for (item in items) {
        println(item)
    }

    // in 연산자를 사용해서 컬렉션에 특정 값이 포함되어 있는지 검사 할 수 있다.
    when {
        "banana" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    // 람다식을 사용해서 컬렉션을 filter, map 할 수 있다.
    items
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}


// Nullable values and null checks
// null 을 허용하려면 타입 이름 뒤에 ? 를 붙인다.
// val a: String?
// fun parseInt(str: String): Int?

// null 값이 가능한 타입의 변수를 사용하려면 null 체크를 해야 한다.
fun parseInt(str: String): Int? {
    if (str == "") {
        return null
    }
    return str.toInt()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // x * y 를 사용하면 컴파일 에러가 발생한다.
    // 이유는 x 나 y 가 null 일 수 있기 때문이다.
    if (x != null && y != null) {
        // null 체크를 통과하면 x 와 y 는 자동으로 non-nullable 로 변환된다.
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}


// Type checks and automatic casts
// is 연산자를 사용해서 타입을 검사 할 수 있다. 이 연산자는 자동으로 타입 변환을 해준다.
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // obj 가 자동으로 String 타입으로 변환된다.
        return obj.length
    }

    // 타입 검사를 통과하면 자동으로 타입 변환을 해주기 때문에
    // 아래에서는 obj 를 String 타입으로 사용 할 수 없다.
    return null
}
