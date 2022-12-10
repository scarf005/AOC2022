package solutions.day04

import Problem

private infix fun IntRange.containsAll(other: IntRange) = other.first in this && other.last in this
private infix fun IntRange.eitherContainsAll(other: IntRange) = this containsAll other || other containsAll this
private fun rangeLiteral(s: String) = s
    .split("-")
    .let { it[0].toInt()..it[1].toInt() }

fun day04() {
    val day04 = Problem(2022, 4)

    val parsed = day04.input.toList()
        .map { it.split(',').map(::rangeLiteral).let { it[0] to it[1] } }

    val part1 = parsed.count { (a, b) -> a eitherContainsAll b }
    println(part1)

    val part2 = parsed.count { (a, b) -> (a intersect b).isNotEmpty() }
    println(part2)
}
