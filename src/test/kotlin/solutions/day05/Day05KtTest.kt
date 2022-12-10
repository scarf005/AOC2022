package solutions.day05

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.arbitrary.triple
import io.kotest.property.checkAll

class Day05KtTest : StringSpec({
    "parseMove" {
        checkAll(Arb.triple(Arb.positiveInt(), Arb.positiveInt(), Arb.positiveInt())) { (a, b, c) ->
            "move $a from $b to $c".parseMove() shouldBe Move(a, b - 1, c - 1)
        }
    }
})
