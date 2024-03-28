import kotlin.properties.Delegates
import kotlin.reflect.KProperty


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class DelegatedPropertiesExample {
    var p: String by Delegate()
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

class UserForDelegatesObservable {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("[${prop.name}] $old -> $new")
    }
}

class UserForDelegatesVetoable {
    var name: String by Delegates.vetoable("<no name>") { prop, old, new ->
        println("[${prop.name}] $old -> $new")
        new.length <= 5// 5글자 이하값만 적용함
    }
}

class MyClassForDelegates {
    // oldName을 newName으로 대체함
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
    var newName: Int = 0
}

class UserForDelegatesMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}


fun main() {
//    val e = DelegatedPropertiesExample()
//    println(e.p)
//    e.p = "NEW"

//    println(lazyValue)
//    // computed!
//    // Hello
//
//    println(lazyValue)
//    // Hello

//    val user = UserForDelegatesObservable()
//    user.name = "first" // [name] <no name> -> first
//    println(user.name) // first
//    user.name = "second" // [name] first -> second
//    println(user.name) // second

//    val user = UserForDelegatesVetoable()
//    user.name = "first" // [name] <no name> -> first
//    println(user.name) // first
//    user.name = "second value" // [name] first -> second
//    println(user.name) // first

//    val myClass = MyClassForDelegates()
//    myClass.oldName = 10
//    println(myClass.newName) // 10


    val map = mapOf(
        "name" to "John Doe",
        "age" to 25,
        "num" to 12,
        "someString" to "String Value"
    )
    val user = UserForDelegatesMap(map)

    println(map.get("name")) // John Doe
    println(user.name) // John Doe

    println(map.get("age")) // 25
    println(user.age) // 25
}
