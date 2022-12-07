import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

object FlattenWithTest : StringSpec({
    "[], a -> NoSuchElementException" {
        shouldThrow<NoSuchElementException> {
            emptyList<Int>().flattenWith(0)
        }
    }
    val separator = 0
    "[a, .. a], b -> [a, b, .. a, b]" {
        checkAll(Arb.list(digitArb, 1..10)) { list ->
            val expected = run {
                val b = mutableListOf<Int>()
                list.dropLast(1).forEach { e -> b.addAll(sequenceOf(e, separator)) }
                b += list.last()
                b
            }

            list.flattenWith(separator) shouldBe expected
        }
    }
})