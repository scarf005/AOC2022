package solutions.day06

import Problem


fun String.isUnique() = length == toSet().size


fun day06() {
    val data = Problem(2022, 6).input

    fun String.solve(size: Int) =
        windowed(size)
            .mapIndexed { index, fourChar -> index + size to fourChar }
            .find { (_, str) -> str.isUnique() }

    data.forEach { it.solve(4)?.let { (index, _) -> println(index) } }
    data.forEach { it.solve(14)?.let { (index, _) -> println(index) } }
}
