package solutions.day02

import Problem

fun day02() {
    val data = Problem(2022, 2).input
    val parsed = data.map { it.first() to it.last() }

    val part1 = parsed
        .map { (l, r) -> l.toHand() to r.toHand() }
        .sumOf { (opponent, you) -> you playScore opponent }

    println(part1)

    val part2 = parsed
        .map { (l, r) -> l.toHand() to r.toResult() }
        .sumOf { (opponent, result) -> opponent.whichGives(result).score + result.score }

    println(part2)
}

fun Char.toHand() = when (this) {
    'X', 'A' -> Hand.Rock
    'Y', 'B' -> Hand.Paper
    'Z', 'C' -> Hand.Scissors
    else -> throw IllegalArgumentException("Unknown hand: $this")
}

fun Char.toResult() = when (this) {
    'X' -> Result.Lose
    'Y' -> Result.Draw
    'Z' -> Result.Win
    else -> throw IllegalArgumentException("Unknown result: $this")
}

infix fun Hand.whichGives(result: Result) = when (result) {
    Result.Win -> lostBy()
    Result.Draw -> this
    Result.Lose -> wonBy()
}
