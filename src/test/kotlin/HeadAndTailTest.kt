import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.pair
import io.kotest.property.checkAll
import io.kotest.property.forAll

@ExperimentalStdlibApi
object HeadAndTail : StringSpec({
    "[] -> NoSuchElementException" {
        shouldThrow<NoSuchElementException> {
            emptyList<Int>().headAndTail()
        }
    }
    "[a] -> (a, [])" {
        forAll<Int> {
            listOf(it).headAndTail() == Pair(it, emptyList<Int>())
        }
    }
    "[a, ...rest] -> (a, rest)" {
        checkAll(Arb.pair(Arb.int(), Arb.list(Arb.int(), 1..<100))) { (a, b) ->
            (listOf(a) + b).headAndTail() shouldBe Pair(a, b)
        }
    }
})