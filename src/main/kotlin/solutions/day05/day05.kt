package solutions.day05

import transpose

//fun parse(input: String): Pair<List<String>, Sequence<String>> {
//    val (containers, moves) = input.lines().splitWhen(String::isBlank).toList().let { it[0].toList() to it[1].asSequence() }
//
//    return containers to moves
//}


fun parseCrates(input: List<String>) {
    val height = input.size - 1
//    val totalStacks = input.last().split(" ").asSequence().filterNot(String::isEmpty).last().toInt()

    val crates = input.dropLast(1).map { it.chunked(4).map { it.trim(' ', '[', ']') } }
        .mapIndexed { index, list ->
            "H$index" to list.mapIndexed { i, c -> "I$i" to c }.filter { it.second.isNotBlank() }
        }
    /*
    .D
    NC
    ZMP

     to

     ZN
     MCD
     P
     */

// convert [[(Empty), D], [N, C], [Z, M, P]] into[[Z, N], [M, C, D], [P]]
//   D
// N C
// Z M P
// ^: H, >: I
    // Z: I0H2


    println(crates.toList())
    println("height: $height")
}

fun String.parseMove(): Triple<Int, Int, Int> =
    split(" ")
        .filter { it.all(Char::isDigit) }.map(String::toInt)
        .let { (a, b, c) -> Triple(a, b, c) }

fun day05() {
//    val foo = listOf(listOf('!', 'D'), listOf('N', 'C'), listOf('Z', 'M', 'P'))
    val foo = "123456789".chunked(3).map { it.toList() }
    println(foo)
    println(foo.transpose())
//    147
//    258
//    369


//    val data = Problem(2022, 5).example
//
//    val (crates, moves) = data.toList().splitWhen(String::isBlank).toList()
//        .let { it[0].toList() to it[1].asSequence() }
//
//    parseCrates(crates)
//    println(moves)
}
