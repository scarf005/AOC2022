import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.div

fun String.toPath() = Path(this)

fun <T> Iterable<T>.toPath() = joinToString(File.separator).toPath()
fun Path.expandHome(): Path = when (first()) {
    Path("~") -> System.getProperty("user.home").toPath() / drop(1).toPath()
    else -> this
}

infix fun Path.withSuffix(suffix: String): Path = (parent / (fileName.toString() + suffix))
