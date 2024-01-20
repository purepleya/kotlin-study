
// getter, setter
class GetterSetterDemo {
//    초기 값에 세팅 되지 않으면 타입을 추측하지 못하기 때문에, 초기값을 세팅하던, 타입을 작성하던 해야 한다.
//    var initialized // 에러 발생

//    값이 할당되지 않았다면, 타입을 명시해야 하고, 초기화 블록을 통해 값을 할당하던, initializer를 통해 값을 할당해야 한다.
    var initialized2: String
    init {
        initialized2 = "abc"
    }


//    값이 할당되었다면, 타입을 추론할 수 있어서 타입을 생략할 수 있다.
    var initialized3 = "abc"

}


class GetterSetterDemo2(val width: Int, val height: Int) {
    // val 로 선언한 경우, setter를 생성 할 수 없다.
    val area: Int
        get() {
            println("getter called")
            return this.width * this.height
        }

    val area2 get() = this.width * this.height // get 에서 타입을 추론 할 수 있다면 속성의 타입을 생략 할 수 있다.

    var name: String = "John"
        set(value) {
            println("setter called")
            field = "Name: $value"
        }
}


class BackingFieldDemo {
    var counter = 0
        get() {
             println("getter called counter: $field")
            return field
        }
        // 음수는 들어 올 수 없다.
        set(value) {
            if (value >= 0) {
                field = value // field 대신에 counter라는 필드명을 사용하면 setter가 무한 호출 된다.
            }
        }
}


fun main() {
//    val getterSetterDemo = GetterSetterDemo()
//    println(getterSetterDemo.name)
//    getterSetterDemo.name = "Doe"
//    println(getterSetterDemo.name)

//    val getterSetterDemo2 = GetterSetterDemo2(3, 2)
//    println("area1 : ${getterSetterDemo2.area}")
//    속성에 접근할때 마다 getter가 호출 된다
//    getter called
//    area1 : 6

//    println("area2 : ${getterSetterDemo2.area2}")
//    area2 : 6

//    getterSetterDemo2.name = "Doe"
//    속성에 접근할때 마다 setter가 호출 된다
//    setter called
//    println(getterSetterDemo2.name)
//    Name: Doe

    var backingFieldDemo = BackingFieldDemo()
    backingFieldDemo.counter = -1
    println(backingFieldDemo.counter)
//    getter called counter: 0
//    0
    backingFieldDemo.counter = 12
    println(backingFieldDemo.counter)
//    getter called counter: 12
//    12
}