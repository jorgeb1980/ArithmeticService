package arithmetic

import org.hamcrest.Matchers.comparesEqualTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.math.BigDecimal

class BasicTests {

    private val ops = ArithmeticOperations()

    @Test
    fun testAdd() {
        assertThat(ops.add(), comparesEqualTo(BigDecimal.ZERO))
        assertThat(
            ops.add(
                BigDecimal(3),
                BigDecimal(2.5),
                BigDecimal(5.5),
                BigDecimal(-2.5),
                BigDecimal(7),
                BigDecimal(0.5)
            ),
            comparesEqualTo(BigDecimal(16))
        )
        assertThat(ops.add(BigDecimal(2)), comparesEqualTo(BigDecimal(2)))

    }

    @Test
    fun testSubtract() {
        assertThat(ops.subtract(BigDecimal(5), BigDecimal(3)), comparesEqualTo(BigDecimal(2)))
        assertThat(ops.subtract(BigDecimal(5), BigDecimal(12)), comparesEqualTo(BigDecimal(-7)))
    }

    @Test
    fun testMultiply() {
        assertThat(ops.product(), comparesEqualTo(BigDecimal.ZERO))
        assertThat(
            ops.product(BigDecimal(2), BigDecimal(3), BigDecimal(4)),
            comparesEqualTo(BigDecimal(24))
        )
        assertThat(
            ops.product(BigDecimal(2), BigDecimal(3), BigDecimal(-4)),
            comparesEqualTo(BigDecimal(-24))
        )
        assertThat(
            ops.product(BigDecimal(-2), BigDecimal(3), BigDecimal(-4)),
            comparesEqualTo(BigDecimal(24))
        )
    }

    @Test
    fun testDivision() {
        var result: Pair<Int, Int> = ops.integerDivision(5, 3)
        assertEquals(1, result.first)
        assertEquals(2, result.second)

        result = ops.integerDivision(4, 2)
        assertEquals(2, result.first)
        assertEquals(0, result.second)
    }

}