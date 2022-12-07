import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val fileName = if (args.isNotEmpty()) args[0] else "src/main/resources/01.txt"

    val file = File(fileName)
    val values = file
        .readLines()
        .splitWhen { it.isBlank() }
        .map { array -> array.map (String::toInt)  }

    println(values)
}