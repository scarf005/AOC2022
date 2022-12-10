package listutils

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.pair
import io.kotest.property.forAll
import splitBy

@Suppress("unused")
object CutHalfTest : StringSpec({
    "[...].cutHalf(0) -> ([...], [])" {
        forAll<List<Int>> { list ->
            list.splitBy(0) == Pair(emptyList<Int>(), list)
        }
    }
    "[1, 2, .. N].cutHalf(N) -> ([1, 2, .. N], [])" {
        forAll<List<Int>> { list ->
            list.splitBy(list.size) == Pair(list, emptyList<Int>())
        }
    }
    "[1, 2, .. A .. B].cutHalf(A) -> ([1, 2, .. A], [A + 1, .. B])" {
        forAll(Arb.pair(Arb.list(Arb.int()), Arb.list(Arb.int()))) { (a, b) ->
            (a + b).splitBy(a.size) == Pair(a, b)
        }
    }
})
