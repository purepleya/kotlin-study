fun main() {
//    할당된 값을 보고 타입을 Int로 추론한다.
    var customer = 10
    println(customer)

//    따라서 아래 연산들이 가능해진다.

    customer += 2
    println(customer)

    customer *= 3
    println(customer)

    customer /= 2
    println(customer)


//    Kotlin의 기본 타입
//    - 정수형 (Integers)
//        Byte, Short, Int, Long
//
//    - 부호가 없는 정수 형 (Unsigned integers)
//        UByte, UShort, UInt, ULong
//
//    - 부동 소수점 숫자 (Floating point numbers)
//        Float, Double
//
//    - 논리 (Booleans)
//        Boolean
//
//    - 문자 (Characters)
//        Char
//
//    - 문자열 (Strings)
//        String


//    선언을 먼저하고
    val a: Int
//    할당을 나중에 할 수도 있다.
    a = 1
    println(a)

//    선언과 동시에 할당도 가능하다.
    val b: String = "!!!!!!!!!!!!"
    println(b)



}