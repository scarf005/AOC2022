fun <T> combine(y: T, h: List<T>, ys: List<T>, t: Nested<T>): Nested<T> =
    listOf(listOf(y) + h) + (listOf(ys) + t).transpose()


fun <T> Nested<T>.transpose(): Nested<T> = when {
    isEmpty() -> emptyList()
    first().isEmpty() -> drop(1).transpose()
    else -> {
        val (x, xs, xss) = this.headAndTail().let { (a, b) -> Triple(a.first(), a.drop(1), b) }
        val (hds, tls) = xss.map { it.headAndTail() }.unzip()
        combine(x, hds, xs, tls)
    }
}

/** @returns a nested list rotated 90 degrees clockwise */
fun <T> Nested<T>.rotateRight(): Nested<T> = transpose().map { it.reversed() }

/** @returns a nested list rotated 90 degrees counter-clockwise */
fun <T> Nested<T>.rotateLeft(): Nested<T> = transpose().reversed()
