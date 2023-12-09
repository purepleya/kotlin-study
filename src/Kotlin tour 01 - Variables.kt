fun main() {

//    val 은 read-only 변수이다. (immutable)
//    var 는 read-write 변수이다. (mutable)
    val popcorn = 5    // There are 5 boxes of popcorn
    val hotdog = 7     // There are 7 hotdogs
    var customers = 10 // There are 10 customers in the queue

    println(popcorn)
    println(hotdog)
    println(customers)

    println("=====================================")
    
// Some customers leave the queue
//    popcorn = 6    // error (val cannot be reassigned)
//    hotdog = 8     // error (val cannot be reassigned)
    customers = 11

    println(popcorn)
    println(hotdog)
    println(customers)
}
