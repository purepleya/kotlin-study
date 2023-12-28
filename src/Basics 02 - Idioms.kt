import my.demo.Rectangle
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

// data class를 이용하여 DTO 만든다
// data class Customer(val name: String, val email: String)
// equals(), hashCode(), toString(), copy() 메소드가 자동으로 생성됨


// 함수의 매개변수에 기본값을 사용
fun foo(a: Int = 0, b: String = "") {
    println("a: $a, b: $b")
}

// Filter a list
//val positives = list.filter { x -> x > 0 }
// or
//val positives2 = list.filter { it > 0 }


// collection 의 원소로 특정 엘리먼트가 포함되어 있는지 확인 할 때는 in 연산자를 사용
//val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
//if ("orange" in fruits) { ... }
//if ("apple" !in fruits) { ... }


// 문자열 보간
//"Name $name, Age: $age"


// 타입 체크
//when (x) {
//    is Foo -> ...
//    is Bar -> ...
//    else   -> ...
//}


// read-only list
//val list = listOf("a", "b", "c")


// read-only map
//val map = mapOf("a" to 1, "b" to 2, "c" to 3)


// 맵의 원소에 접근
//println(map["key"])
//map["key"] = value


// map 의 원소를 순회
//for ((k, v) in map) { ... }


// range 순회
//for (i in 1..100) { ... }  // closed range: includes 100
//for (i in 1..<100) { ... } // half-open range: does not include 100
//for (x in 2..10 step 2) { ... }
//for (x in 10 downTo 1) { ... }
//(1..100).forEach { println(it) }


// lazy property - 최초로 접근할 때 값이 계산되어 초기화 된다.
//val p: String by lazy {
//    // compute the string
//}


// Extension functions - 확장 함수
// fun String.spaceToCamelCase() { ... }
// "Convert this to camelcase".spaceToCamelCase()


// Create a singleton
//object Resource {
//    val name = "Name"
//}


//abstract class 타입 instance 생성
abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

fun doWithMyAbstractClass() {
    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            // abstract function 구현
        }

        override fun sleep() {
            // abstract function 구현
        }
    }
    myObject.doSomething()
}


// if-not-null 축약형
fun ifNotNullShorthand() {
    val files = File("Test").listFiles()
    println(files?.size)
}


// if-not-null-else 축약형
fun ifNotNullElseShorthand() {
    val files = File("Test").listFiles()
    println(files?.size ?: "empty")

    val fileSize = files?.size ?: run { // run() 함수를 이용하여 블록을 실행
        val somSize = 23
        somSize + 7
    }

    println(fileSize)
}


// null일때 실행되는 문 구현
fun ifNullThrowException () {
    val value:String? = null
    val valueNotNull = value ?: throw IllegalStateException("value is null")
}


// nullable collection의 첫번째 값 가져오기
fun getFirstOrNull() {
    val nullableList: List<String>? = null
    val firstItem = nullableList?.firstOrNull() ?: "empty"
}


// null 이 아닌 경우 실행 하기
fun executeIfNotNull() {
    val value:String? = null
    value?.let {
        // value가 null이 아닌 경우 실행
    }
}


//null 이 아닌경우 값 변경하기
fun changeValueIfNotNull() {
    val makeUpperCase: (String) -> String = { it.toUpperCase() }

    var value:String? = "hello"
    val mapped = value?.let { makeUpperCase(value) } ?: "empty"
}


// return 문에 when 사용하기
fun returnWhen() {
    val value = 1
    val result = when (value) {
        0 -> "zero"
        1 -> "one"
        else -> "other"
    }
}


// try-catch 식
fun tryCatch() {
    val result = try {
        // 예외가 발생할 수 있는 코드
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }

    // working with result
}


// if문을 식으로 사용하기
fun ifAsExpression() {
    val value = 1
    val result = if (value == 1) {
        "one"
    } else {
        "other"
    }
}


// Unit 타입을 리턴하는 (리턴타입이 없는) 함수를 빌더처럼 사용 할 수 있다. - 이걸 어따쓰는겨
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}


// 단일 표현식 함수
fun theAnswer() = 42
// 아래와 똑같음
fun theAnswer2(): Int {
    return 42
}

// when을 이용해서 아래와 같은 작성이 가능
fun transform(color: String): Int  = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }


// with 문을 이용해 인스턴스를 생략 할 수 있다.
class Turtle {
    fun penDown() {}
    fun penUp() {}
}

fun turtle() {
    val myTurtle = Turtle()

    with(myTurtle) { // 인스턴스를 생략
        penDown() // myTurtle.penDown() 으로 컴파일 됨
        for (i in 1..4) {
//            ...
        }
        penUp() // myTurtle.penUp() 으로 컴파일 됨
    }
}


// object 속성값 적용, 변경하기 (apply 함수 사용)
fun objectProperty() {
    val myRectangle = Rectangle(3, 2)

    myRectangle.apply {
        width = 4
    }
}


// java 7 의 try-with-resources 구문과 비슷한 use 함수
fun howToUseUse() {
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }
}


// Generic 함수 -- 따로 공부좀 해야 할듯


// 두 값 바꾸기 (also)
fun swap() {
    var a = 1
    var b = 2
    a = b.also { b = a }
}


// 미 완성 코드 작성하기 (TODO)
fun todo() {
    val result = TODO("result 생성하는 함수 작성")
}