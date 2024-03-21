interface  BaseInterface {
    val message: String
    fun printMessage()
    fun printMessageLine()
    fun print()
}

class BaseImpl(val x: Int) : BaseInterface {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }

    override val message: String = "BaseImpl: x = $x"

    override fun print() {
        println(message)
    }
}

class DerivedClass(b: BaseInterface) : BaseInterface by b {
    override fun printMessage() {
        print("abc")
    }

    fun printMessage2() {
        printMessage()
    }

    override val message = "Message of DerivedClass"
}

fun main() {
    val b = BaseImpl(10)
    DerivedClass(b).printMessage() // abc
    println()
    DerivedClass(b).printMessageLine() // 10

    val derived = DerivedClass(b)
    derived.print() // BaseImpl: x = 10
    println(derived.message) // Message of DerivedClass
}

