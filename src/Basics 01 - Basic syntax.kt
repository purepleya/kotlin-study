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
class Rectangle(val height: Int, val width: Int) {
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




