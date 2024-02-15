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

fun main() {
    println(ProtocolState.WAITING)
//    WAITING
    println(ProtocolState.WAITING.signal())
//    TALKING
}

open class HelloEnum {
    open fun sayHello() {
        println("This is HelloEnum")
    }
}

// class는 상속 받을 수 없음
enum class ChildEnum: HelloEnum() {
}