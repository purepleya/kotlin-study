
// constructor 키워드를 사용하여 primary constructor 정의
class Person constructor(firstName: String) {
}

/*
primary constructor 가 어노테이션이나, 접근제한자를 정의할 필요가 없다면,
constructor 키워드를 생략 할 수 있다.
 */
class Person2 (firstName: String) {
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        // 주 생성자에서 사용된 파라미터를 init 블록에서 사용할 수 있다.
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class PropertyDemo (
    val name: String,
    var age: Int,
    gender: String, // , 로 마무리 해도 된다.
) {
}


class SecondaryConstructorDemo {
    constructor(name: String) {
        println("constructor with $name")
    }
}


class SecondaryConstructorDemo2 (name: String) {

//    primary constructor 와 중복되어 에러 발생
//    constructor(name: String): this(name) {
//        println("constructor")
//    }

//    primary constructor를 호출하지 않아서 에러 발생
//    constructor(name: String, age: Int) {
//        println("constructor")
//    }


//    정상 케이스
    constructor(name: String, age: Int): this(name) {
        println("constructor")
    }
}


class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }

    init {
        println("Init block2")
    }
}

class SingletonDemo private constructor() {
    /* ... */
}


fun main() {
//    val initOrderDemo = InitOrderDemo("hello")
//    ==========================================
//    First property: hello
//    First initializer block that prints hello
//    Second property: 5
//    Second initializer block that prints 5

//    val propertyDemo = PropertyDemo("JH", 45, "male")
//    println(propertyDemo.name)
//    println(propertyDemo.age)
//    println(propertyDemo.gender) // gender 속성은 없음
//    ==========================================
//    JH
//    45


    var constructors = Constructors(1)
//    ==========================================
//    Init block
//    Init block2
//    Constructor
}
