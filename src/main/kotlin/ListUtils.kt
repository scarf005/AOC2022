/** @return pair of first value and the rest of the list */
fun <T> Iterable<T>.headAndTail() = first() to drop(1)
fun <T> Iterable<T>.tail() = drop(1)
fun <T> List<T>.initAndLast() = dropLast(1) to last()

/**
 * @param n the number of elements to take from the beginning of the list
 * @return a pair of lists, the first containing the first n elements of the list, the second containing the remaining elements
 */
fun <T> Iterable<T>.splitBy(n: Int) = take(n) to drop(n)

//fun <T> Collection<T>.cutHalf() = splitBy(size / 2)

/**
 * flatten with separators inserted.
 *
 *  @param separator the separator to insert between each element
 */
fun <T> List<List<T>>.flattenWith(separator: T): List<T> {
    val (init, last) = initAndLast()
    val mapped = init.asSequence().flatMap { it + separator }
    return (mapped + last).toCollection(ArrayList())
}

typealias nested<T> = Collection<Collection<T>>
