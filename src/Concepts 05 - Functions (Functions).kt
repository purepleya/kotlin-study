open class FunctionA {
    open fun foo(i: Int = 10) {
        println("FunctionA.foo($i)")
    }
}

class FunctionB : FunctionA() {
    override fun foo(i: Int) {
        println("FunctionB.foo($i)")
    }
}

fun foo(
    bar: Int = 0,
    baz: Int,
) { /*...*/ }


fun varargFunction(i: Int, vararg strings: String) {
    println ("=====varargFunction=====")
    strings.forEach { println(it) }
}

fun varargFunction2(vararg strings: String, i: Int) {
    println ("=====varargFunction2=====")
    strings.forEach { println(it) }
}

fun main() {
//    val b = FunctionB()
//    b.foo() // FunctionB.foo(10)

    varargFunction(10, "1", "2", "3")
    varargFunction2("1", "2", "3", i = 10)
}