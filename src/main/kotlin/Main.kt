fun main() {
    val day03 = Problem(2022, 3)
    println(day03.input)
}


/*
//typealias TestData = NonEmptyList<String>

typealias SolveFun<T> = (TestData) -> T

val solve01: SolveFun<Int> = {
    it
        .splitWhen(String::isBlank)
        .map { array -> array.map(String::toInt) }
        .maxOf { it.sum() }
}

val solve01_2: SolveFun<Int> = { data ->
    data
        .splitWhen(String::isBlank)
        .asSequence()
        .map { array -> array.map(String::toInt) }
        .map { it.sum() }
        .sortedDescending()
        .take(3)
        .sum()
}

enum class Hand(val score: Int) { Rock(1), Paper(2), Scissors(3) }

fun Char.toHand() = when (this) {
    'X', 'A' -> Hand.Rock
    'Y', 'B' -> Hand.Paper
    'Z', 'C' -> Hand.Scissors
    else -> throw IllegalArgumentException("Unknown hand: $this")
}


infix fun Hand.wins(other: Hand) = when (this) {
    Hand.Rock -> other == Hand.Scissors
    Hand.Paper -> other == Hand.Rock
    Hand.Scissors -> other == Hand.Paper
    else -> false
}

infix fun Hand.outcome(other: Hand): Int = when {
    this wins other -> Result.Win.score
    other wins this -> Result.Lose.score
    else -> Result.Draw.score
}

infix fun Hand.play(other: Hand): Int = score + outcome(other)

val solve02: SolveFun<Int> = { data ->
    data
        .map { Pair(it.first().toHand(), it.last().toHand()) }
        .sumOf { (opponent, you) -> you play opponent }
}

enum class Result(val score: Int) { Win(6), Draw(3), Lose(0) }

fun Char.toResult() = when (this) {
    'X' -> Result.Lose
    'Y' -> Result.Draw
    'Z' -> Result.Win
    else -> throw IllegalArgumentException("Unknown result: $this")
}

fun Hand.wonBy() = when (this) {
    Hand.Rock -> Hand.Scissors
    Hand.Paper -> Hand.Rock
    Hand.Scissors -> Hand.Paper
}

fun Hand.lostBy() = when (this) {
    Hand.Rock -> Hand.Paper
    Hand.Paper -> Hand.Scissors
    Hand.Scissors -> Hand.Rock
}

infix fun Hand.whichGives(result: Result) = when (result) {
    Result.Win -> lostBy()
    Result.Draw -> this
    Result.Lose -> wonBy()
}

val solve02_2: SolveFun<Int> = { data ->
    data
        .map { Pair(it.first().toHand(), it.last().toResult()) }
        .sumOf { (opponent, result) -> opponent.whichGives(result).score + result.score }
}
*/
