
// Kotlin 은 클래스와 오브젝트를 이용한 객체지향 프로그래밍을 지원한다.

// 속성은 아래 Customer 클래스 처럼 클래스 명 뒤 ()괄호 안에 선언하거나(class header),
// category 처럼 클래스 안에 선언할 수 있다. (class body)
// 함수에서 처럼 기본 값을 지정 할 수 있다.(email)
class Customer (var name: String, val email: String = "sample@email.com") {
    val category: String = "default category"
}

// 클래스의 인스턴스를 생성하기 위해서는 생성자(constructor)를 사용하며, new 키워드는 사용하지 않는다.
// 기본적으로, 코틀린은 class header의 파라미터를 필요로 하는 생성자를 만든다.

//    인스턴스의 속성에 접근하려면 .(dot)을 사용한다.
//println("Customer name: ${customer.name}")
//customer.name = "Jane Doe2"

// Member functions
// 클래스 안에 오브젝트의 행동을 정의하는 함수를 선언 할 수 있다.
// Member functions 는 클래스내부에 정의 되어야 하며, 속성과 마찬가지로 .(dot)을 사용해서 호출한다. (ex. customer.printName());
class Customer2 (var name: String, val email: String) {
    fun printName() {
        println("Customer name: $name")
    }
}

fun main() {
    val customer = Customer("John Doe", "john@email.com")

    println("Customer name: ${customer.name}")

    customer.name = "Jane Doe2"
    println("Customer name: ${customer.name}")


    val customer2 = Customer2("John Doe3", "johndoe@email.com")
    customer2.printName()
}