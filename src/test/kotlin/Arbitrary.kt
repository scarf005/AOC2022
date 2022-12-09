import io.kotest.property.Arb
import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.list

val digitArb = arbitrary { rs: RandomSource -> rs.random.nextInt(1, 9) }
val chunkArb = arbitrary { Arb.list(digitArb, 1..3).bind() }
