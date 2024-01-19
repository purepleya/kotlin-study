
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






    var name: String = "John"
        get() = field.toUpperCase()
        set(value) {
            field = "Name: $value"
        }
}


fun main() {
    val getterSetterDemo = GetterSetterDemo()
    println(getterSetterDemo.name)
    getterSetterDemo.name = "Doe"
    println(getterSetterDemo.name)
}