fun main() {
//    usecaseOfSwap()


//    val ex = Example()
//    ex.printFunctionType()
//    Class method
//    ex.printFunctionType(2)
//    Extension function overload : value is 2

    MyClass.printCompanion()
//    companion
}

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


class Example {
    fun printFunctionType() { println("Class method") }
}

fun Example.printFunctionType() { println("Extension function") }
fun Example.printFunctionType(i: Int) { println("Extension function overload : value is $i") }


fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

// 오류 : initializers are not allowed for extension properties
//val <T> List<T>.lastIndex: Int = 10

val <T> List<T>.lastIndex: Int
    get() = size - 1


class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.printCompanion() { println("companion") }
