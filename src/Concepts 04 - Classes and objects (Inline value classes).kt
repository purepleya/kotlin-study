@JvmInline
value class PersonInline(private val fullName: String) {
    init {
        require(fullName.isNotEmpty()) {
            "Full name sholdn't be empty"
        }
    }

    constructor(firstName: String, lastName: String): this("$firstName $lastName") {
        require(lastName.isNotBlank()) {
          "Last name shouldn't be empty"
        }
    }

    val length: Int
        get() = fullName.length

    fun greet() {
        println("Hello, $fullName")
    }
}


interface Printable {
    fun prettyPrint(): String
}

@JvmInline
value class Name(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}



typealias NameTypeAlias = String

@JvmInline
value class NameInlineClass(val s: String)

fun acceptString(s: String) = println("acceptString : ${s}")
fun acceptNameTypeAlias(s: NameTypeAlias) = println("acceptNameTypeAlias : ${s}")
fun acceptNameInlineClass(s: NameInlineClass) = println("acceptNameInlineClass : ${s.s}")


fun main() {
//    val name1 = PersonInline("Kotlin", "Mascot")
//    val name2 = PersonInline("Kodee")
//
//    name1.greet()
//    // Hello, Kotlin Mascot
//
//    println(name2.length)
//    // 5

//    val name = Name("Kotlin")
//    println(name.prettyPrint())

    val nameAlias: NameTypeAlias = "a"
    val nameInlineClass: NameInlineClass = NameInlineClass("b")
    val string: String = "c"

    acceptString(string)
    acceptString(nameAlias)
//    acceptString(nameInlineClass) // compile error - 호환 불가

    acceptNameTypeAlias(string)
    acceptNameTypeAlias(nameAlias)
//    acceptNameTypeAlias(nameInlineClass)  // compile error  - 호환 불가

//    acceptNameInlineClass(string)  // compile error  - 호환 불가
//    acceptNameInlineClass(nameAlias)  // compile error  - 호환 불가
    acceptNameInlineClass(nameInlineClass)
}