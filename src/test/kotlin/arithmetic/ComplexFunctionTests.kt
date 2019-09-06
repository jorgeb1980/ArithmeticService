package arithmetic

import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ComplexFunctionTests {

    val ops = ArithmeticOperations()
    fun bd(f: Float) = BigDecimal(f.toString())

    @Test
    fun testMean() {
        Assert.assertThat(bd(5f), Matchers.comparesEqualTo(ops.mean(bd(5f), bd(4f), bd(6f))))
        Assert.assertThat(bd(0f), Matchers.comparesEqualTo(ops.mean(bd(5f), bd(-5f), bd(1f), bd(-1f))))
    }

    @Test
    fun testMedian() {
        Assert.assertThat(bd(6f),
            Matchers.comparesEqualTo(
                    ops.median(bd(3f), bd(1f), bd(3f), bd(9f), bd(8f), bd(7f), bd(6f))))
        Assert.assertThat(bd(4.5f),
            Matchers.comparesEqualTo(
                    ops.median(bd(9f), bd(1f), bd(8f), bd(2f), bd(6f), bd(3f), bd(5f), bd(4f))))
    }
}