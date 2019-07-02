import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.libs.ws.WSClient
import play.api.test.{DefaultAwaitTimeout, FutureAwaits}

class ExampleIntegrationTest extends PlaySpec with ScalaFutures with GuiceOneServerPerSuite with IntegrationPatience with FutureAwaits with DefaultAwaitTimeout {

  implicit val wsClient = app.injector.instanceOf[WSClient]

  override def fakeApplication() = super.fakeApplication()

  "GET /example" should {
    "return a list of state objects" in {

      val response = await(wsUrl("/example").get())

      response.status mustBe 200
    }
  }

}


