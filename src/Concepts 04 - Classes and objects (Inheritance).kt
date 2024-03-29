open class Base(p: Int) {
    init {
        println("Base class init block $p")
    }
}

class Derived(p: Int) : Base(p) {
    init {
        println("Derived class init block $p")
    }
}


class Derived2 : Base {
    constructor(p: Int) : super(p) {
        println("Derived2 class init block $p")
    }
}

open class Base2 {

}
class Derived3 : Base2() {

}


open class OverrideBase {
    fun u() {
        println("base final")
    }

    open fun v() {
        println("base open")
    }

    open fun v2() {
        println("base open2")
    }
}

open class OverrideDerived : OverrideBase() {
//    compile 오류 발생
//    override fun u() {
//        println("derived final")
//    }
    override fun v() {
        println("derived override")
    }

//    OverrideDerived 를 상속하는 클래스에서는 v2() 를 override 하지 못하도록 한다.
    final override fun v2() {
        println("derived override2")
    }
}

class OverrideDerived2 : OverrideDerived() {
    override fun v() {
        println("derived2 override")
    }

//    컴파일 에러 - final 로 선언되어 있어서 override 불가
//    override fun v2() {
//        println("derived2 override2")
//    }
}

open class SuperClassDemoBase {
    val v get() = "SuperClassDemoBase value"
    open fun f() {
        println("SuperClassDemoBase f()")
    }
}

class SuperClassDemoDerived : SuperClassDemoBase() {
    override fun f() {
        super.f()
        println("SuperClassDemoDerived f()")
    }

    val v2 get() = "SuperClassDemoDerived value ${super.v}"

    inner class SuperClassDemoDerivedInner {
        fun callF() {
            super@SuperClassDemoDerived.f()
            f()
            println("SuperClassDemoDerivedInner callF()")
        }
    }
}

open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }
}

interface Polygon {
    fun draw() {
        println("Drawing a polygon")
    }
}

class Square : Rectangle(), Polygon {
    // draw()는 Rectangle, Polygon양쪽에 있기때문에 override 하지 않으면 컴파일 에러 발생
    override fun draw() {
        // 어떤 상위 클래스의 draw() 를 호출할지 지정해야 한다.
        super<Rectangle>.draw()
        super<Polygon>.draw()
    }
}



fun main() {
//    val a = Derived(10)
//    Base class init block 10
//    Derived class init block 10

//    val b = Derived2(5)
//    Base class init block 5
//    Derived2 class init block 5

    val s = SuperClassDemoDerived()
    s.f()
//    SuperClassDemoBase f()
//    SuperClassDemoDerived f()

    println(s.v2)
//    SuperClassDemoDerived value SuperClassDemoBase value

    val i = s.SuperClassDemoDerivedInner()
    i.callF()
//    SuperClassDemoBase f()
//    SuperClassDemoBase f()
//    SuperClassDemoDerived f()
//    SuperClassDemoDerivedInner callF()
}