fun <T> combine(y: T, h: List<T>, ys: List<T>, t: Nested<T>): Nested<T> {
    val foo = (listOf(y) + h)
    val arr = listOf(ys) + t
    val bar = arr.transpose()
    return listOf(foo) + bar
}

fun <T> Nested<T>.transpose(): Nested<T> = when {
    isEmpty() -> emptyList()
    first().isEmpty() -> drop(1).transpose()
    else -> {
        val (x, xs, xss) = this.headAndTail().let { (a, b) -> Triple(a.first(), a.drop(1), b) }
        val (hds, tls) = xss.map { it.headAndTail() }.unzip()
        combine(x, hds, xs, tls)
    }
}

/*
123
456
789

 */
