import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

// 일반적인 enum
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// 속성값이 있는 경우 초기화
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    }; // 세미 콜론을 붙여서 아래 멤버(abstract fun signal()...) 와 분리

    abstract fun signal(): ProtocolState
}


open class HelloEnum {
    open fun sayHello() {
        println("This is HelloEnum")
    }
}

// compile error - class는 상속 받을 수 없음
//enum class ChildEnum: HelloEnum() {
//}

interface HelloInterface {
    fun sayHello()
}

enum class ChildEnum2: HelloInterface {
    A {
        override fun sayHello() {
            println("This is A")
        }
    },
    B {
        override fun sayHello2() {
            println("This is B")
        }
    },
    C;

    override fun sayHello() {
        println("This is Common")
        sayHello2()
    }

    open fun sayHello2() {
        println("This is Common2")
    }
}





fun main() {
//    ChildEnum2.A.sayHello()
//    This is A

//    ChildEnum2.B.sayHello()
//    This is Common
//    This is B

//    ChildEnum2.C.sayHello()
//    This is Common
//    This is Common2


    for (e in ChildEnum2.entries) {
        println("name : ${e.name}, ordinal : ${e.ordinal}")
    }
//    name : A, ordinal : 0
//    name : B, ordinal : 1
//    name : C, ordinal : 2

    val a = ChildEnum2.valueOf("A")
    println(a)
//    A
    val b = ChildEnum2.valueOf("B")
    println(b)
//    B


    for (e in enumValues<ChildEnum2>()) {
        println("name : ${e.name}, ordinal : ${e.ordinal}")
    }
//    name : A, ordinal : 0
//    name : B, ordinal : 1
//    name : C, ordinal : 2

    val a2 = enumValueOf<ChildEnum2>("A")
    println(a2)
//    A


}