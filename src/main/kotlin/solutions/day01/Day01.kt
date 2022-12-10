package solutions.day01

import Problem
import splitWhen

fun day01() {
    val day01 = Problem(2022, 1)

    val parsed = day01.example.toList().splitWhen(String::isBlank)
        .asSequence()
        .map { array -> array.map(String::toInt).sum() }

    println(parsed.max())
    println(parsed.sortedDescending().take(3).sum())
}
