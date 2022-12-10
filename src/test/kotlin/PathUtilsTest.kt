import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.io.path.Path

@Suppress("unused")
object PathUtilsTest : StringSpec({
    "Iterable<String>.toPath" {
        listOf("a", "b", "c").toPath() shouldBe Path("a/b/c")
    }

    "Path.expandHome" {
        Path("~").expandHome() shouldBe Path(System.getProperty("user.home"))
    }
    "no home to expand" {
        val noTilde = Path("a/b/c")
        noTilde.expandHome() shouldBe noTilde
    }
})
