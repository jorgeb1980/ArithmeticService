package arithmetic

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class ArithmeticController {

    @PostMapping("/add")
    fun add(@RequestBody values: List<BigDecimal>): BigDecimal {
        return ArithmeticOperations().add(*values.toTypedArray())
    }

    @PostMapping("/subtract")
    fun subtract(@RequestBody values: Map<String, BigDecimal>): BigDecimal {
        val minuend: BigDecimal = values["minuend"] ?: BigDecimal("0")
        val subtrahend: BigDecimal = values["subtrahend"] ?: BigDecimal("0")
        return ArithmeticOperations().subtract(minuend, subtrahend)
    }

    @PostMapping("/product")
    fun product(@RequestBody values: List<BigDecimal>): BigDecimal {
        return ArithmeticOperations().product(*values.toTypedArray())
    }

    @PostMapping("/integerDivision")
    fun integerDivision(@RequestBody values: Map<String, Int>): Pair<Int, Int> {
        val dividend: Int = values["dividend"] ?: 0
        val divisor: Int = values["divisor"] ?: 1
        return ArithmeticOperations().integerDivision(dividend, divisor)
    }

    @PostMapping("/mean")
    fun mean(@RequestBody values: List<BigDecimal>): BigDecimal {
        return ArithmeticOperations().mean(*values.toTypedArray())
    }

    @PostMapping("/median")
    fun median(@RequestBody values: List<BigDecimal>): BigDecimal {
        return ArithmeticOperations().median(*values.toTypedArray())
    }
}