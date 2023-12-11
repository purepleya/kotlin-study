fun main() {
//    Collection types
//    - Lists : Ordered collections of items
//    - Sets : Unique unordered collections of items
//    - Maps : Sets of key-value pairs where keys are unique and map to only one value


//    List
//    read only list(List)는 listOf() 함수로 만들고
//    mutable list(MutableList)는 mutableListOf() 함수로 만든다.

    val readOnlyShapes = listOf("triangle", "square", "circle")
//    read only list는 수정 함수가 없다.
    println(readOnlyShapes)

    val mutableShapes = mutableListOf("triangle", "square", "circle")
//    mutable list는 수정 함수(add, addAll, remove등)가 있다.
    println(mutableShapes)
    mutableShapes.add(1, "rectangle")
    println(mutableShapes)
    mutableShapes.removeAt(3)
    println(mutableShapes)

//    혹시 mutable list를 read only list로 바꾸고 싶다면, toList() 함수를 사용하거나, List 변수에 할당해서 casting을 해주면 된다.
    val readOnlyShapes2 = mutableShapes.toList()
    val readOnlyShapes3: List<String> = mutableShapes

//    원소에 접근할 때는 get() 함수를 사용하거나, []를 사용하면 된다.
    println("second element of ${readOnlyShapes3} is ${readOnlyShapes3.get(1)}")
    println("second element of ${readOnlyShapes3} is ${readOnlyShapes3[1]}")

//    first, last 같은 함수도 있다.
    println("first element of ${readOnlyShapes3} is ${readOnlyShapes3.first()}")
    println("last element of ${readOnlyShapes3} is ${readOnlyShapes3.last()}")

//    어떤 원소를 포함하는지 확인하고 싶으면 in 함수를 사용한다.
    println("is ${readOnlyShapes3} contains \"triangle\"? ${"triangle" in readOnlyShapes3}")

}