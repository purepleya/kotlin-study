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


