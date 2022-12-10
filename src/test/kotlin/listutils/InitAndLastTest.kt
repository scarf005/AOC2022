package listutils

import initAndLast
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

@Suppress("unused")
object InitAndLastTest : StringSpec({
    "[] -> NoSuchElementException" {
        shouldThrow<NoSuchElementException> {
            emptyList<Int>().initAndLast()
        }
    }
    // write tests similar to HeadAndTail
    "[a] -> ([], [a])" {
        checkAll<Int> {
            listOf(it).initAndLast() shouldBe Pair(emptyList<Int>(), it)
        }
    }
})
