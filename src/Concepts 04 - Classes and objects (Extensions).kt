fun main() {
//    usecaseOfSwap()


//    val ex = Example()
//    ex.printFunctionType()
//    Class method
//    ex.printFunctionType(2)
//    Extension function overload : value is 2


//    MyClass.printCompanion()
//    companion


//    val host = Host("kotl.in")
//    Connection(host, 443).connect()
//    host.printConnectionString() // 컴파일 에러, 확장 함수는 호스트 클래스 안에서만 사용 가능


    ExtensionBaseCaller().call(ExtensionBase())
//    Base extension function in ExtensionBaseCaller
    ExtensionBaseCaller().call(ExtensionDerived())
//    Base extension function in ExtensionBaseCaller

    ExtensionBaseCaller().callDerived(ExtensionDerived())
//    Derived extension function in ExtensionBaseCaller

    ExtensionDerivedCaller().call(ExtensionBase())
//    Base extension function in ExtensionDerivedCaller - dispatch receiver is resolved virtually
    ExtensionDerivedCaller().call(ExtensionDerived())
//    Base extension function in ExtensionDerivedCaller - extension receiver is resolved statically

    ExtensionDerivedCaller().callDerived(ExtensionDerived())
//    Derived extension function in ExtensionDerivedCaller
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



class Host(val hostname: String) {
    fun printHostname() { print(hostname) }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }

    // Host 클래스가 extension receiver
    // Connection 클래스가 dispatch receiver
    fun Host.printConnectionString() {
        printHostname()
        print(":")
        printPort()
    }

    fun Host.getConnectionString() {
        toString() // Host의 toString()을 호출
        this@Connection.toString() // Connection의 toString()을 호출
    }

    fun connect() {
        host.printConnectionString()
    }
}

open class ExtensionBase {}
class ExtensionDerived : ExtensionBase() {}

open class ExtensionBaseCaller {
    open fun ExtensionBase.printFunction() {
        println("Base extension function in ExtensionBaseCaller")
    }

    open fun ExtensionDerived.printFunction() {
        println("Derived extension function in ExtensionBaseCaller")
    }

    fun call(b: ExtensionBase) {
        b.printFunction()
    }

    fun callDerived(b: ExtensionDerived) {
        b.printFunction()
    }
}

class ExtensionDerivedCaller : ExtensionBaseCaller() {
    override fun ExtensionBase.printFunction() {
        println("Base extension function in ExtensionDerivedCaller")
    }

    override fun ExtensionDerived.printFunction() {
        println("Derived extension function in ExtensionDerivedCaller")
    }
}
