fun main() {
//    labelDemo2()
    foo1()
    foo2()
    foo3()
    foo4()
}


fun labelDemo() {
    for (i in 1..3) {
        for (j in 100..103) {
            if (i == 2) {
                break // 현재 가장 가까운 반복문인 for (j..) 에 break 가 걸린다.
            }
            println("i: $i, j: $j")
        }
    }


    iLoop@ for (i in 1..3) {
        jLoop@ for (j in 100..103) {
            if (i == 2) {
                break@iLoop // iLoop 에 break 가 걸린다.
            }
            println("i: $i, j: $j")
        }
    }
}

fun labelDemo2() {
    for (i in 1..3) {
        for (j in 100..103) {
            if (j == 101) { // 현재 가장 가까운 반복문인 for (j..) 에 continue 가 걸린다.
                continue
            }
            println("i: $i, j: $j")
        }
    }


    iLoop@ for (i in 1..3) {
        jLoop@ for (j in 100..103) {
            if (j == 101) {
                continue@iLoop // iLoop 에 continue 가 걸린다.
            }
            println("i: $i, j: $j")
        }
    }
}

fun foo1() {
    println("foo1 ====================")
    // 람다 식 에서는 non-local return으로 동작한다.
    listOf(1, 2, 3, 4).forEach {
        if (it == 3) return // foo1() 함수를 리턴한다. (non-local return)
        print(it)
    }
    println("this point is unreachable") // 여기까지 못옴
}

fun foo2() {
    println("foo2 ====================")
    // 람다 식 에서는 local return으로 동작하기 위해서는 label을 붙여야 한다.
    listOf(1, 2, 3, 4).forEach lit@{
        if (it == 3) return@lit // 람다 식을 리턴한다. (local return)
        print(it)
    }
    println("done with explicit label")
}

fun foo3() {
    println("foo3 ====================")
    // 암시적 label(implicit labels)을 사용할 수도 있다.
    listOf(1, 2, 3, 4).forEach{
        if (it == 3) return@forEach // 람다 식을 리턴한다. (local return)
        print(it)
    }
    println("done with implicit label")
}

fun foo4() {
    println("foo4 ====================")
    listOf(1, 2, 3, 4).forEach(fun (it: Int){
        if (it == 3) return // 익명 함수를 리턴한다. (local return)
        print(it)
    })
    println(" done with anonymous function")
}