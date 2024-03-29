import java.io.File

typealias FileTable<K> = MutableMap<K, MutableList<File>>

typealias MyHandler = (Int, String, Any) -> Unit
typealias Predicate<T> = (T) -> Boolean

class AForTypeAlias {
    inner class Inner
}

class BForTypeAlias {
    class Inner
}

typealias AInner = AForTypeAlias.Inner
typealias BInner = BForTypeAlias.Inner