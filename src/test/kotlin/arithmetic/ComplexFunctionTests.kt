package arithmetic

import org.hamcrest.Matchers.comparesEqualTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.math.BigDecimal

class ComplexFunctionTests {

    private val ops = ArithmeticOperations()

    @Test
    fun testMean() {
        assertThat(
            ops.mean(BigDecimal(5), BigDecimal(4), BigDecimal(6)),
            comparesEqualTo(BigDecimal(5))
        )
        assertThat(
            ops.mean(BigDecimal(5), BigDecimal(-5), BigDecimal(1), BigDecimal(-1)),
            comparesEqualTo(BigDecimal(0))
        )
    }

    @Test
    fun testMedian() {
        assertThat(
            ops.median(
                BigDecimal(3),
                BigDecimal(1),
                BigDecimal(3),
                BigDecimal(9),
                BigDecimal(8),
                BigDecimal(7),
                BigDecimal(6)
            ),
            comparesEqualTo(BigDecimal(6))
        )
        assertThat(
            ops.median(
                BigDecimal(9),
                BigDecimal(1),
                BigDecimal(8),
                BigDecimal(2),
                BigDecimal(6),
                BigDecimal(3),
                BigDecimal(5),
                BigDecimal(4)
            ),
            comparesEqualTo(BigDecimal(4.5))
        )
    }
}