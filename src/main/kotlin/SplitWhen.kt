typealias Nested<T> = Collection<Collection<T>>

private tailrec fun <T> Collection<T>.f(p: (T) -> Boolean, agg: Collection<T>, acc: Nested<T>): Nested<T> =
    when {
        isEmpty() -> acc + arrayOf(agg)
        else -> when {
            p(first()) -> tail().f(p, emptyList(), acc + listOf(agg))
            else -> tail().f(p, agg + first(), acc)
        }
    }

fun <T> Collection<T>.splitWhen(p: (T) -> Boolean): Nested<T> = f(p, emptyList(), emptyList())
