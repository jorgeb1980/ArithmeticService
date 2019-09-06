package arithmetic

import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class BasicTests {

    private val ops = ArithmeticOperations()

    fun bd(f: Float) = BigDecimal(f.toString())

    @Test
    fun testAdd() {
        Assert.assertThat(bd(16f),
                Matchers.comparesEqualTo(ops.add(bd(3f), bd(2.5f),
                        bd(5.5f), bd(-2.5f), bd(7f), bd(0.5f))))
        Assert.assertThat(bd(2f),
                Matchers.comparesEqualTo(ops.add(bd(2f))))

    }

    @Test
    fun testSubtract() {
        Assert.assertThat(bd(2f), Matchers.comparesEqualTo(ops.subtract(bd(5f), bd(3f))))
        Assert.assertThat(bd(-7f), Matchers.comparesEqualTo(ops.subtract(bd(5f), bd(12f))))
    }

    @Test
    fun testMultiply() {
        Assert.assertThat(bd(24f), Matchers.comparesEqualTo(ops.product(bd(2f), bd(3f), bd(4f))))
        Assert.assertThat(bd(-24f), Matchers.comparesEqualTo(ops.product(bd(2f), bd(3f), bd(-4f))))
        Assert.assertThat(bd(24f), Matchers.comparesEqualTo(ops.product(bd(-2f), bd(3f), bd(-4f))))
    }

    @Test
    fun testDivision() {
        var result: Pair<Int, Int> = ops.integerDivision(5, 3)
        Assert.assertEquals(1, result.first)
        Assert.assertEquals(2, result.second)

        result = ops.integerDivision(4, 2)
        Assert.assertEquals(2, result.first)
        Assert.assertEquals(0, result.second)
    }

}