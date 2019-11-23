package arithmetic

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.MathContext
import java.util.*

/**
 * This class implements the core logic: simple arithmetic functions
 */
@Service
class ArithmeticOperations {

    /**
     * Summatory of all the values in the list
     * @param values List of values
     * @returns Summatory of the list
     */
    fun add(vararg values: BigDecimal) = values.reduce { sum, element -> sum + element }

    /**
     * Difference between 2 values
     * @param minuend Value from which we subtract the subtrahend
     * @param subtrahend Value that we are subtracting from the minuend
     * @returns Difference between minuend and subtrahend
     */
    fun subtract(minuend: BigDecimal, subtrahend: BigDecimal) = minuend - subtrahend;

    /**
     * Product of all the values in the list
     * @param values List of values
     * @returns Product of all the values in the list
     */
    fun product(vararg values: BigDecimal) = values.reduce { product, element -> product * element }

    /**
     * Integer division of two numbers
     * @param dividend Number that we divide by the divisor
     * @param divisor Number by which we divide the dividend
     * @returns Pair of values: quotient and remainder of the division
     */
    fun integerDivision(dividend: Int, divisor: Int) = Pair<Int, Int>(dividend/divisor, dividend % divisor)

    /**
     * Arithemtic mean of a list of numbers
     * @param values List of values of which we calculate arithmetic mean
     * @returns Arithmetic mean of the values in the list, or 0 if the list is empty
     */
    fun mean(vararg values: BigDecimal): BigDecimal {
        return if (values.isEmpty()) BigDecimal("0.0") else (add(*values).divide(BigDecimal(values.size), MathContext.DECIMAL64))
    }

    /**
     * Calculates median of the list
     * @param values List of values whose median we want to calculate
     * @returns Median of the list of values according to median defition:
     *  https://en.wikipedia.org/wiki/Median
     */
    fun median(vararg values: BigDecimal): BigDecimal {
        val list = values.toList()
        Collections.sort(list)
        return if (list.size % 2 == 0) {
            // If even: arithmetic mean of central values of the sorted collection
            mean(*arrayOf(list[(list.size/2) - 1], list[list.size/2]))
        }
        else {
            // If uneven: central value of the sorted collection
            list[list.size / 2]
        }
    }
 }