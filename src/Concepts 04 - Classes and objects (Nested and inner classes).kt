interface OuterInterface {
    class InnterClass
    interface InnerInterface
}


class OuterClass {
    class InnerClass
    interface InnerInterface
}


class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

fun main() {
    println(Outer().Inner().foo())
    // 1

    executeHello(object: SampleInterface {
        override fun hello() {
            println("Hello1")
        }

        override fun hello2() {
            println("Hello2")
        }
    })
}

interface SampleInterface {
    fun hello()
    fun hello2()
}


fun executeHello(helloService: SampleInterface) {
    helloService.hello()
    helloService.hello2()
}
