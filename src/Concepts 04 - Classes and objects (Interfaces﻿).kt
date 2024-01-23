interface MyInterface {
    fun bar()

    fun foo() {
        // body
    }
}

class Child: MyInterface {
    override fun bar() {
//        구현되지 않은 bar 함수를 구현해야 한다.
    }

    // foo 함수는 구현하지 않아도 된다.
}

interface MyInterface2 {
    val prop: Int // 실제 값을 할당하지 않음 (추상화, abstract)

    var prop2: String
        get() = "foo"
        set(value) {
//            field = value //backing field 를 사용할 수 없다. compile error
        }
}

class Child2: MyInterface2 {
    override val prop: Int = 29
}


interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

interface C {
    fun foo() { print("C") }
    fun bar(): Int { return 0 }
}

class D: A {
//    인터페이스에서 구현되지 않은 bar 함수를 구현해야 한다.
    override fun bar() {
        print("bar")
    }
}

//class E: A, C {
//    override fun foo() {
//        super<A>.foo()
//    }
//
////    A 와 C 에서 정의된 bar 함수의 리턴타입이 서로 다르기때문에 컴파일 에러가 발생한다.
//    override fun bar() {
//    }
//}

class F: A, B {
//    A와 B 에서 foo 함수가 구현되어 있기때문에 헷갈리지 않게 정확히 어떻게 동작할지를 구현해야 한다.
    override fun foo() {
        super<A>.foo() // A 의 foo 함수를 호출한다.
        super<B>.foo() // B 의 foo 함수를 호출한다.
    }

    override fun bar() {
        super<B>.bar()
    }
}