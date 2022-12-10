package solutions.day03

import Problem
import cutHalf

private fun Char.priority(): Int = when (this) {
    in 'a'..'z' -> this - 'a' + 1
    in 'A'..'Z' -> this - 'A' + 27
    else -> throw IllegalArgumentException(""""$this" cannot be converted to a priority""")
}

fun day03() {
    val data = Problem(2022, 3).input

    val part1 = data
        .map(String::cutHalf)
        .map { (a, b) -> a.toSet() to b.toSet() }
        .map { (a, b) -> (a intersect b).first() }
        .sumOf(Char::priority)

    println(part1)

    val part2 = data
        .chunked(3) { (a, b, c) -> Triple(a.toSet(), b.toSet(), c.toSet()) }
        .map { (a, b, c) -> (a intersect b intersect c).first() }
        .sumOf(Char::priority)

    println(part2)
}
