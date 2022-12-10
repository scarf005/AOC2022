package listutils

import chunkArb
import flattenWith
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

@Suppress("unused")
object FlattenWithTest : StringSpec({
    "[[]], a -> []" {
        listOf(emptyList<Int>()).flattenWith(0) shouldBe emptyList()
    }
    "[[7], [2]] -> [7, 0, 2]" {
        listOf(listOf(7), listOf(2)).flattenWith(0) shouldBe listOf(7, 0, 2)
    }
    val separator = 0
    "[[..] [..]" {
        checkAll(Arb.list(chunkArb, 1..10)) { list ->
            val expected = run {
                val b = mutableListOf<Int>()
                list.dropLast(1).forEach { e -> b.addAll(e + separator) }
                b += list.last()
                b
            }
            list.flattenWith(separator) shouldBe expected
        }
    }
})
