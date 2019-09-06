package arithmetic

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@Configuration
@EnableWebMvc
@ComponentScan("arithmetic")
open class TestWebConfig {

    // This class allows Spring to have a valid
    //  web context in order to start a service and expose the end points during the
    //  integration tests
}