import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import java.net.URL
import kotlin.io.path.*

private const val BASE_URL = "https://adventofcode.com"
private val resourcesPath = Path("src/main/resources")
private val configPath = Path("~/.config/aoc").expandHome()
private val token = (configPath / "token").readText()
    .split(":").last().trim('\n', '"')

private fun Int.twoDigit() = if (this < 10) "0$this" else this.toString()

/**
 * Represents a problem from the Advent of Code event.
 *
 * @property year The year of the event.
 * @property day The day of the event.
 * @property example A lazy-initialized non-empty list of strings that represent the example input for the problem.
 * @property input A lazy-initialized non-empty list of strings that represent the input for the problem.
 */
data class Problem(val year: Int, val day: Int) {
    @Suppress("unused")
    @OptIn(UnsafeNonEmptyCollectionApi::class)
    val example: NonEmptyList<String> by lazy { examplePath.readLines().toNonEmptyList() }

    @OptIn(UnsafeNonEmptyCollectionApi::class)
    val input: NonEmptyList<String> by lazy {
        when {
            inputPath.exists() -> inputPath.readLines()
            else -> fetchInput().also { saveInput(it) }.lines()
        }.toNonEmptyList()
    }

    private val examplePath = resourcesPath / day.twoDigit() withSuffix (".txt")
    private val inputPath = configPath / year.toString() / "input" / day.twoDigit() withSuffix (".txt")
    private fun saveInput(text: String) = inputPath.also { it.parent.toFile().mkdirs() }.writeText(text)
    private fun fetchInput() =
        URL("$BASE_URL/$year/day/$day/input")
            .openConnection()
            .apply { setRequestProperty("Cookie", "session=$token") }
            .getInputStream().bufferedReader().readText()

}
