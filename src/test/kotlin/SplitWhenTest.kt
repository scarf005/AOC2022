import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

@Suppress("unused")
object SplitWhenTest : StringSpec({
    "[] -> [[]]" {
        emptyList<Int>().splitWhen { true } shouldBe listOf(emptyList())
    }
    "[a, .. a] -> [[a, .. a]]" {
        checkAll(Arb.list(digitArb, 1..10)) { list ->
            list.splitWhen { false } shouldBe listOf(list)
        }
    }
    "predefined test" {
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).splitWhen { it % 3 == 0 } shouldBe listOf(
            listOf(1, 2),
            listOf(4, 5),
            listOf(7, 8),
            emptyList(),
        )
    }
    "binary test" {

        /**
         * 1. create arbitrary 2d list of integers (>0)
         * 2. join them, while inserting 0
         * 3. example: [[1, 11, 3], [3, 2], [6, 7], [5]]
         *       -> [1, 11, 3, 0, 3, 2, 0, 6, 7, 0, 5]
         */
        checkAll(Arb.list(chunkArb, 1..3)) { nested ->
            nested.flattenWith(0).splitWhen { it == 0 } shouldBe nested
        }
    }
})
