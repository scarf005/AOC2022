package solutions.day02

enum class Result(val score: Int) { Win(6), Draw(3), Lose(0) }

enum class Hand(val score: Int) {
    Rock(1), Paper(2), Scissors(3);

    fun wonBy() = when (this) {
        Rock -> Scissors
        Paper -> Rock
        Scissors -> Paper
    }

    fun lostBy() = when (this) {
        Rock -> Paper
        Paper -> Scissors
        Scissors -> Rock
    }

    infix fun wins(other: Hand) = other.lostBy() == this
    infix fun loses(other: Hand) = other.wonBy() == this
    infix fun play(other: Hand): Result = when {
        this wins other -> Result.Win
        other wins this -> Result.Lose
        else -> Result.Draw
    }

    infix fun playScore(other: Hand) = score + (this play other).score
}
