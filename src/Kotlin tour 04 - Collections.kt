fun main() {
//    Collection types
//    - Lists : Ordered collections of items
//    - Sets : Unique unordered collections of items
//    - Maps : Sets of key-value pairs where keys are unique and map to only one value


//    List
//    read only list(List)는 listOf() 함수로 만들고
//    mutable list(MutableList)는 mutableListOf() 함수로 만든다.

//    List를 선언할때 타입을 명시하지 않으면 값으로 타입을 추론하고, 명시하고 싶을때는 <타입>을 붙여준다.

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


    println("=====================================")
//    Set
//    read only set(Set)은 setOf() 함수로 만들고,
//    mutable set(MutableSet)을 만들때는 mutableSetOf() 함수로 만든다.
//    sets을 생성할대 저장되는 item을 보고 타입을 추론하기도 하며, 특정 타입을 명시적으로 선언 하고 싶을때는 <> 괄호를 이용한다.

    // Read-only set
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println("readOnlyFruit = ${readOnlyFruit}")

    // 명시적 타입 선언 Mutable set, add, remove 와 같은 수정 함수가 존재함.
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    fruit.add("orange")
    fruit.remove("apple")
    println("fruit = ${fruit}")

//    list 처럼, count, in 함수들이 존재함
    println("is ${fruit} contains \"apple\"? ${"apple" in fruit}")
    println("is ${fruit} contains \"apple\"? ${fruit.contains("apple")}")
    println("how many items ${fruit} has? ${fruit.count()}")
    println("is ${fruit} contains fruit start with a? ${fruit.count { it.startsWith("a") }}")


    println("=====================================")
//    Map
//    Map은 key-value 쌍으로 이루어지고, key를 통해 값에 접근 한다. key는 unique 해야 한다.

//    read only map(Map)은 mapOf() 함수로 만들고,
//    mutable map (MutableMap)은 mutableMapOf() 함수를 이용해 만든다.

//    다른 Collection 과 마찬가지로 저장되는 아이템으로 타입을 유추하고, 명시적으로 선언하고 싶을때는 <> 괄호에 키와 값의 타입을 명시한다.

//    Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("readOnlyJuiceMenu = ${readOnlyJuiceMenu}")

// Mutable map with explicit type declaration
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("mutableJuiceMenu = ${juiceMenu}")

//    Mutable map을 read only map으로 바꾸고 싶다면, toMap() 함수를 사용하거나, Map 변수에 할당해서 casting을 해주면 된다.
    val readOnlyJuiceMenu2 = juiceMenu.toMap()
    val readOnlyJuiceMenu3: Map<String, Int> = juiceMenu

//    원소에 접근할 때는 get() 함수를 사용하거나, []를 사용하면 된다.
    println("price of apple is ${juiceMenu.get("apple")}")
    println("price of kiwi is ${juiceMenu["kiwi"]}")

//    mutable map 에는 put, remove, clear 와 같은 수정 함수가 존재하고, key가 존재하는지 확인하기 위해 containsKey 함수를 사용한다.
    val mutableJuiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    mutableJuiceMenu.put("banana", 200)
    println("put banana ${mutableJuiceMenu}")

    mutableJuiceMenu.remove("apple")
    println("remove apple ${mutableJuiceMenu}")

    println("is ${mutableJuiceMenu} contains key \"apple\"? ${mutableJuiceMenu.containsKey("apple")}")

    mutableJuiceMenu.clear()
    println("clear mutableJuiceMenu ${mutableJuiceMenu}")



}