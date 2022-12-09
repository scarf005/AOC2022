private tailrec fun <T> Collection<T>.f(p: (T) -> Boolean, agg: Collection<T>, acc: nested<T>): nested<T> =
    when {
        isEmpty() -> acc + arrayOf(agg)
        else -> when {
            p(first()) -> tail().f(p, emptyList(), acc + listOf(agg))
            else -> tail().f(p, agg + first(), acc)
        }
    }

fun <T> Collection<T>.splitWhen(p: (T) -> Boolean): nested<T> = f(p, emptyList(), emptyList())
