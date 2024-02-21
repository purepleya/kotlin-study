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



fun main() {
    val name1 = PersonInline("Kotlin", "Mascot")
    val name2 = PersonInline("Kodee")

    name1.greet()
    // Hello, Kotlin Mascot

    println(name2.length)
    // 5
}