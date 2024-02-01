data class User(val name: String, val age: Int)


fun derivedMembers() {
    val u1 = User("John", 25)
    val u2 = User("John", 25)
    val u3 = User("John", 26)

    println("equals: ${u1.equals(u2)}") // equals: true
    println("equals: ${u1.equals(u3)}") // equals: false

    println("hashCode: ${u1.hashCode()}") // hashCode: 71750734

    println("toString: ${u1.toString()}") // toString: User(name=John, age=25)

    println("component1: ${u1.component1()}") // component1: John
    println("component2: ${u1.component2()}") // component2: 25

    val u4 = u3.copy()
    println("copy: ${u4.toString()}") // copy: User(name=John, age=26)
}

fun copying() {
    val u1 = User("John", 25)
    val u2 = u1.copy()
    println("copy: ${u2.toString()}") // copy: User(name=John, age=25)

//    일부 값을 변경해서 복사할 수 있다.
    val u3 = u1.copy(age = 30)
    println("copy: ${u3.toString()}") // copy: User(name=John, age=30)
}

data class PersonDataClass(val name: String) {
    var age: Int = 0
}

fun propertiesDeclaredInClass() {
    val p1 = PersonDataClass("John")
    p1.age = 25

    val p2 = PersonDataClass("John")
    p2.age = 27

    println("equals: ${p1.equals(p2)}") // equals: true
    println("toString: ${p1.toString()}") // toString: PersonDataClass(name=John)
}


fun desctructuring() {
    val u1 = User("John", 25)
    val (name, age) = u1
    println("name: $name, age: $age") // name: John, age: 25
}

fun main() {
//    derivedMembers()
//    propertiesDeclaredInClass()
//    copying()
    desctructuring()
}

