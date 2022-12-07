import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.arbitrary

val digitArb = arbitrary { rs: RandomSource -> rs.random.nextInt(1, 9) }