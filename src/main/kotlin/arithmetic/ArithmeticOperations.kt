package arithmetic

import java.util.*

/**
 * This class implements the core logic: simple arithmetic functions
 */
class ArithmeticOperations {

    /**
     * Summatory of all the values in the list
     * @param values List of values
     * @returns Summatory of the list
     */
    fun add(vararg values: Float) = values.reduce { sum, element -> sum + element }

    /**
     * Subtraction of 2 s
     * @param minuend Value from which we subtract the subtrahend
     * @param subtrahend Value that we are subtracting from the minuend
     * @returns Difference between minuend and subtrahend
     */
    fun subtract(minuend: Float, subtrahend: Float) = minuend - subtrahend;

    /**
     * Product of all the values in the list
     * @param values List of values
     * @returns Product of all the values in the list
     */
    fun product(vararg values: Float) = values.reduce { product, element -> product * element }

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
    fun mean(vararg values: Float): Float {
        return if (values.isEmpty()) 0f else (add(*values) / values.size)
    }

    /**
     * Calculates median of the list
     * @param values List of values whose median we want to calculate
     * @returns Median of the list of values according to median defition:
     *  https://en.wikipedia.org/wiki/Median
     */
    fun median(vararg values: Float): Float {
        val list = values.toList()
        Collections.sort(list)
        return if (list.size % 2 == 0) {
            // If even: arithmetic mean of central values of the sorted collection
            mean(*floatArrayOf(list[(list.size/2) - 1], list[list.size/2]))
        }
        else {
            // If uneven: central value of the sorted collection
            list[list.size / 2]
        }
    }
 }