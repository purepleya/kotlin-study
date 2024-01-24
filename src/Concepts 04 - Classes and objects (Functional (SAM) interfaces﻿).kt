fun interface KRunnable {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

// 위와 같이 구현해야하는 코드를 SAM 전환을 통해 아래처럼 간결하게 작성 할 수 있다.

var isEven2 = IntPredicate { it % 2 == 0 }

//fun main() {
//    println(isEven.accept(2))
//    println(isEven2.accept(2))
//}


typealias IntPredicate2 = (i: Int) -> Boolean

var isEven3: IntPredicate2 = { it % 2 == 0 }

fun main() {
    println(isEven3(2))
}