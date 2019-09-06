package arithmetic

import com.google.gson.Gson
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.mock.web.MockServletContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.math.BigDecimal
import java.net.URI


@RunWith(SpringJUnit4ClassRunner::class)
@AutoConfigureMockMvc
@WebAppConfiguration
@ContextConfiguration(classes = arrayOf(TestWebConfig::class))
@ActiveProfiles(profiles = arrayOf("test"))
open class IntegrationTests {


    @Autowired
    private var mockMvc: MockMvc? = null

    @Autowired
    private var wac: WebApplicationContext? = null

    @Before
    @Throws(Exception::class)
    fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    fun testWebAppContextAvailable() {
        val servletContext = wac?.getServletContext()

        Assert.assertNotNull(servletContext)
        Assert.assertTrue(servletContext is MockServletContext)
    }

    @Test
    fun testIntegrationAdd() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                    .post(URI("/add"))
                    .content("[1,2]")
                    .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        Assert.assertThat(BigDecimal(3), Matchers.comparesEqualTo(BigDecimal(res)))
    }

    @Test
    fun testIntegrationSubtract() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                        .post(URI("/subtract"))
                        .content("{\"minuend\":4.5, \"subtrahend\":3.2}")
                        .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        Assert.assertThat(BigDecimal("1.3"), Matchers.comparesEqualTo(BigDecimal(res)))
    }

    @Test
    fun testIntegrationProduct() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                        .post(URI("/product"))
                        .content("[1,2,3,4.1]")
                        .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        Assert.assertThat(BigDecimal("24.6"), Matchers.comparesEqualTo(BigDecimal(res)))
    }

    @Test
    fun testIntegrationIntegerDivision() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                        .post(URI("/integerDivision"))
                        .content("{\"dividend\":5, \"divisor\":3}")
                        .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        val gson = Gson()
        val ret = gson.fromJson(res, Map::class.java)
        val quotient = BigDecimal(ret["first"] as Double)
        val remainder = BigDecimal(ret["second"] as Double)
        Assert.assertThat(BigDecimal("1"), Matchers.comparesEqualTo(quotient))
        Assert.assertThat(BigDecimal("2"), Matchers.comparesEqualTo(remainder))
    }

    @Test
    fun testIntegrationMean() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                        .post(URI("/mean"))
                        .content("[1,2,9,5,0.1,12]")
                        .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        Assert.assertThat(BigDecimal("4.85"), Matchers.comparesEqualTo(BigDecimal(res)))
    }

    @Test
    fun testIntegrationMedian() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                        .post(URI("/median"))
                        .content("[1,2,3,4,5,6]")
                        .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        Assert.assertThat(BigDecimal("3.5"), Matchers.comparesEqualTo(BigDecimal(res)))
    }

    @Test
    fun testIntegrationMedianUneven() {
        val result = mockMvc?.perform(
                MockMvcRequestBuilders
                        .post(URI("/median"))
                        .content("[1,2,3,4,5]")
                        .contentType(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk)?.andReturn()
        val res : String? = result?.response?.contentAsString
        Assert.assertNotNull(res)
        Assert.assertThat(BigDecimal("3"), Matchers.comparesEqualTo(BigDecimal(res)))
    }
}