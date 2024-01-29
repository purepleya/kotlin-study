fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun usecaseOfSwap() {
    val list = mutableListOf(1, 2, 3)
    println("before swap: $list")
//    before swap: [1, 2, 3]
    list.swap(0, 2)
    println("after swap: $list")
//    after swap: [3, 2, 1]
}


fun main() {
//    usecaseOfSwap()
    val ex = Example()
    ex.printFunctionType()
//    Class method
    ex.printFunctionType(2)
//    Extension function overload : value is 2
}


class Example {
    fun printFunctionType() { println("Class method") }
}

fun Example.printFunctionType() { println("Extension function") }
fun Example.printFunctionType(i: Int) { println("Extension function overload : value is $i") }