import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

object SplitWhen : StringSpec({
    "[] -> [[]]" {
        emptyList<Int>().splitWhen { true } shouldBe listOf(emptyList())
    }
    "predefined test" {
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).splitWhen { it % 3 == 0 } shouldBe listOf(
            listOf(1, 2),
            listOf(4, 5),
            listOf(7, 8),
            emptyList(),
        )
    }
//    "binary test" {

//        val chunkArb = arbitrary { Arb.list(digitArb, 1..3).bind() }
//        val expectedArb = arbitrary { Arb.list(chunkArb, 1..3).bind() }
//        val given = expectedArb.map { it.flatten() + listOf(0) }
//        val plusOne = Arb.int().map { it + 1 }
//        /**
//         * 1. create arbitrary 2d list of integers (>0)
//         * 2. join them, while inserting 0
//         * 3. example: [[1, 11, 3], [3, 2], [6, 7], [5]]
//         *       -> [1, 11, 3, 0, 3, 2, 0, 6, 7, 0, 5]
//         */
//        checkAll(Arb.list(chunkArb, 1..3)) { nested ->
//            val joined = nested.joinTo(List<Int>())
//            val splitted = joined.splitWhen { it == 0 }
//            joined shouldBe splitted
//        }
//
//    }
})
