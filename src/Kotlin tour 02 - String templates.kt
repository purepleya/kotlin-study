fun main() {

//    String template을 이용해서 변수나 다른 객체에 저장된 데이터를 문자열로 변환할 수 있다.
//    템플릿 표현식은 항상 $ 기호로 시작한다.

    val popcorn = 5
    val comment = "There are $popcorn boxes of popcorn"

    println(comment)

    val extraPopcorn = 3
    val comment2 = "There are ${popcorn + extraPopcorn} boxes of popcorn"
    println(comment2)
}