class Box<out T> {
    fun outDemo(value: @UnsafeVariance T) {
        println(value)
    }
}

fun outDemo() {
    val a: Box<String> = Box()
    outDemo2(a)
}


fun outDemo2(p: Box<Any>) {
    p.outDemo("werqwer")
}