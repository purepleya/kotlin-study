// Kotlin 에서는 null값을 가질 수 있다.
// null로 인한 여러가지 문제를 예방하기 위해 코틀린은 null safety를 지원한다.
// null safety는 null 값으로 인한 잠재적 문제를 컴파일 시에 감지 한다.

// Null safety는 아래 기능을 제공한다.
// null 값이 허용되는 경우는 명시적으로 정의 해야 한다.
// null 값을 체크 한다.
// null 값을 제공할 수 있는 속성이나 함수는 safe call 을 사용한다.
// null 값을 받았을때의 액션을 정의 한다.

// Nullable types
// 코틀린에서는 기본적으로 null 값을 허용하지 않는다.
// null 값이 할당될 가능성이 있는경우 선언할 때 타입 뒤에 ?를 붙여서 null 값을 허용 할 수 있다.

// String 타입을 선언하고
//var neverNull: String = "This can't be null"
//
// null 을 할당하면 compile error 가 발생한다.
//neverNull = null
//
// nullable 타입을 선언하면
//var nullable: String? = "You can keep a null here"
//
// null 값을 할당 할 수 있다.
//nullable = null
//
// 타입 자동 할당도 null 값 할당이 불가능하다.
//var inferredNonNull = "The compiler assumes non-nullable"
//inferredNonNull = null // 역시 컴파일 에러
//
// 파라미터가 nullable이 아닌데 nullable 값 할당 하면 컴파일 에러가 난다.
//fun strLength(notNull: String): Int {
//    return notNull.length
//}

//println(strLength(neverNull)) // 18
//println(strLength(nullable))  // 컴파일 에러



// Check for null values
// null 값이 할당 될 수 있는 변수는 if 문을 사용해서 null 값 체크를 해야 한다.

//fun describeString(maybeString: String?): String {
//    if (maybeString != null && maybeString.length > 0) { // null 체크
//        return "String of length ${maybeString.length}"
//    } else {
//        return "Empty or null string"
//    }
//}



// Use safe calls
// null 값이 할당 될 수 있는 object의 함수를 실행시킬때 ?. 연산자를 이용한다.
// ?. 연산자는 null 값이 아닌 경우에만 함수를 실행시켜서 null pointer exception을 방지한다.

//fun lengthString(maybeString: String?): Int? {
//    return maybeString?.length // null 이면 null을 리턴
//}


// Use Elvis operator
// ?: 연산자를 사용하면 null 값이면 다른 값을 할당 할 수 있다.

//fun lengthString(maybeString: String?): Int {
//    val length = maybeString?.length ?: 0 // null 이면 0을 할당
//    return length
//}

