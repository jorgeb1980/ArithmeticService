package arithmetic

import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ComplexFunctionTests {

    val ops = ArithmeticOperations()
    fun bd(f: Float) = BigDecimal(f.toString())

    @Test
    fun testMean() {
        Assert.assertEquals(bd(5f), ops.mean(bd(5f), bd(4f), bd(6f)))
        Assert.assertEquals(bd(0f), ops.mean(bd(5f), bd(-5f), bd(1f), bd(-1f)))
    }

    @Test
    fun testMedian() {
        Assert.assertEquals(bd(6f),
                ops.median(bd(3f), bd(1f), bd(3f), bd(9f), bd(8f), bd(7f), bd(6f)))
        Assert.assertEquals(bd(4.5f),
                ops.median(bd(9f), bd(1f), bd(8f), bd(2f), bd(6f), bd(3f), bd(5f), bd(4f)))
    }
}