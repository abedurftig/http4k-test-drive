package http4k.test.drive

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek

object AppSpec : Spek({

    group("Basic Application Specs") {

        val app = App()
        test("The greeting should be correct") {
            Assertions.assertThat(app.greeting).isEqualTo("Hello World!")
        }
    }
})
