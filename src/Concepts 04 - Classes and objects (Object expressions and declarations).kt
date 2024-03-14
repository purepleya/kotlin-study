
val helloWorld = object {
    val hello = "Hello"
    val world = "World"
    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"
}

class AnonymousObjectAsReturn {
    private fun getObject() = object {
        val x: String = "X of AnonymousObjectAsReturn"
    }
    fun printX() {
        println(getObject().x)
    }

}

interface SuperOfAnonymousA {
    fun funFromA() {}
}

interface SuperOfAnonymousB {

}

class AnonymousC {
    // The return type is Any; x is not accessible
    fun getObject() = object {
        val x: String = "x"
    }
//    fun printlnX1() {
//        println(getObject().x)
//    }


    // The return type is A; x is not accessible
    fun getObjectA() = object: SuperOfAnonymousA {
        override fun funFromA() {}
        val x: String = "x"
    }
//    fun printlnX2() {
//        println(getObjectA().x)
//    }


    // The return type is B; funFromA() and x are not accessible
    fun getObjectB(): SuperOfAnonymousB = object: SuperOfAnonymousA, SuperOfAnonymousB { // explicit return type is required
        override fun funFromA() {}
        val x: String = "x"
    }
//    fun printlnX3() {
//        println(getObjectB().x)
//    }

}



fun main() {
//    println(helloWorld)
    val c = AnonymousObjectAsReturn();
    c.printX();


}
