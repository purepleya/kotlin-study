// 연산자 정의
interface IndexedContainer {
    // 연산자를 정의할때는 operator 수정자를 붙인다.
    operator fun get(index: Int)
}

class OrderList: IndexedContainer {
//    operator 수정자가 붙은 함수를 override 할때는 operator 수정자를 생략 할 수 있다.
    override fun get(index: Int) {
        /* ... */
    }
}


// unary operator
data class Point(val x: Int, val y: Int)
operator fun Point.unaryMinus() = Point(-x, -y)

fun main() {
    val point = Point(10, 20)
    println(-point) // Point(x=-10, y=-20)
}


