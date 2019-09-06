package arithmetic

import org.junit.Assert
import org.junit.Test

class BasicTests {

    private val ops = ArithmeticOperations()

    @Test
    fun testAdd() {
        Assert.assertEquals(16f, ops.add(3f, 2.5f, 5.5f, -2.5f, 7f, 0.5f));
        Assert.assertEquals(2f, ops.add(2f))

    }

    @Test
    fun testSubtract() {
        Assert.assertEquals(2f, ops.subtract(5f, 3f))
        Assert.assertEquals(-7f, ops.subtract(5f, 12f))
    }

    @Test
    fun testMultiply() {
        Assert.assertEquals(24f, ops.product(2f, 3f, 4f))
        Assert.assertEquals(-24f, ops.product(2f, 3f, -4f))
        Assert.assertEquals(24f, ops.product(-2f, 3f, -4f))
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