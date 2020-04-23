package http4k.test.drive

import org.assertj.core.api.Assertions.assertThat
import org.http4k.client.OkHttp
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.spekframework.spek2.Spek

object AppSpec : Spek({

    val app = App()
    val server = app.createMathServer(8080)

    group("Basic Application Specs") {

        test("The greeting should be correct") {
            assertThat(app.greeting).isEqualTo("Hello World!")
        }
    }

    group("Functional tests") {
        test("The endpoint works without starting the server") {

            val unit = app.mathsEndpoint { first, second -> first + second }
            val response = unit(Request(Method.GET, "/")
                .query("first", "4")
                .query("second", "5"))

            assertThat(response.status).isEqualTo(OK)
            assertThat(response.body.toString()).isEqualTo("The answer is 9")
        }
    }

    beforeGroup {
        server.start()
    }

    group("Integration tests") {

        val client = OkHttp()
        test("The endpoint works with starting the server") {

            val clientResponse = client(Request(Method.GET, "http://localhost:8080/add")
                .query("first", "123")
                .query("second", "456"))

            assertThat(clientResponse.status).isEqualTo(OK)
            assertThat(clientResponse.body.toString()).isEqualTo("The answer is 579")
        }
    }

    afterGroup {
        server.stop()
    }
})
