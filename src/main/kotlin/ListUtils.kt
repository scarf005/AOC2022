/** @return pair of first value and the rest of the list */
fun <T> Iterable<T>.headAndTail() = first() to drop(1)

fun <T> List<T>.initAndLast() = dropLast(1) to last()

/**
 * @param n the number of elements to take from the beginning of the list
 * @return a pair of lists, the first containing the first n elements of the list, the second containing the remaining elements
 */
fun <T> Iterable<T>.cutHalf(n: Int) = take(n) to drop(n)

/**
 * flatten with separators inserted.
 *
 *  @param separator the separator to insert between each element
 */
fun <T> List<T>.flattenWith(separator: T): List<T> {
    val (init, last) = initAndLast()
    val mapped = init.asSequence().flatMap { sequenceOf(it, separator) }
    return (mapped + last).toCollection(ArrayList())
}

typealias nested<T> = Collection<Collection<T>>

fun <T> Collection<T>.splitWhen(p: (T) -> Boolean): nested<T> {
    tailrec fun Collection<T>.f(agg: Collection<T>, acc: nested<T>): nested<T> =
        when {
            isEmpty() -> acc + arrayOf(agg)
            else -> {
                val (y, ys) = headAndTail()
                when {
                    p(y) -> ys.f(emptyList(), acc + listOf(agg))
                    else -> ys.f(agg + y, acc)
                }
            }
        }

    return f(emptyList(), emptyList())
}

