package solutions.day05

import Problem
import rotateRight
import splitWhen

data class Move(val amount: Int, val from: Int, val to: Int)

typealias Crates = List<List<String>>
typealias Crate = List<String>
typealias moveFn = (Crate, Int) -> Crate

fun parseCrates(input: Crate): Crates = input.dropLast(1)
    .map { it.chunked(4).map { it.trim(' ', '[', ']') } }
    .rotateRight()
    .map { it.filter(String::isNotEmpty) }


private fun oneByOne(fromCrate: Crate, amount: Int): Crate = fromCrate.takeLast(amount).reversed()
private fun allAtOnce(fromCrate: Crate, amount: Int): Crate = fromCrate.takeLast(amount)


fun Crates.apply(move: Move, fn: moveFn): Crates {
    val (amount, from, to) = move
    val (fromCrate, toCrate) = this[from] to this[to]

    return this.mapIndexed { index, crate ->
        when (index) {
            from -> fromCrate.dropLast(amount)
            to -> toCrate + fn(fromCrate, amount)
            else -> crate
        }
    }
}


fun String.parseMove(): Move =
    split(" ")
        .filter { it.all(Char::isDigit) }.map(String::toInt)
        .let { (a, b, c) -> Move(a, from = b - 1, to = c - 1) }

fun day05() {
    val data = Problem(2022, 5).input

    val (crates, moves) = data.toList().splitWhen(String::isBlank).toList()
        .let { parseCrates(it[0].toList()) to it[1].asSequence().map { it.parseMove() } }

    fun Sequence<Move>.solve(fn: moveFn) = fold(crates) { current, move -> current.apply(move, fn) }
        .joinToString("") { it.last() }

    moves.solve(::oneByOne).also(::println)
    moves.solve(::allAtOnce).also(::println)
}
