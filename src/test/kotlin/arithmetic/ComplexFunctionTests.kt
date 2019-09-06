package arithmetic

import org.junit.Assert
import org.junit.Test

class ComplexFunctionTests {

    val ops = ArithmeticOperations()

    @Test
    fun testMean() {
        Assert.assertEquals(5f, ops.mean(5f,4f,6f))
        Assert.assertEquals(0f, ops.mean(5f, -5f, 1f, -1f))
    }

    @Test
    fun testMedian() {
        Assert.assertEquals(6f, ops.median(3f, 1f, 3f, 9f, 8f, 7f, 6f))
        Assert.assertEquals(4.5f, ops.median(9f, 1f, 8f, 2f, 6f, 3f, 5f, 4f))
    }
}