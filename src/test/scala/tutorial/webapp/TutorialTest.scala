package tutorial.webapp

import utest._

import scala.scalajs.js

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.ext._

import org.scalajs.jquery._

object TutorialTest extends TestSuite {

  // Initialize App
  TutorialApp.setupUI()
  TutorialApp.setupJQueryUI()

  def tests = Tests {
    test("HelloWorld") {
      assert(document.querySelectorAll("p").count(_.textContent == "Hello World") == 1)
      assert(document.querySelectorAll("p").count(_.textContent.startsWith("Hello World")) == 2) // together with a paragraph created by scalajs-jquery
    }

    test("HelloWorld (jQuery)") {
      assert(jQuery("p:contains('Hello World (jQuery)')").length == 1)
      assert(jQuery("p:contains('Hello World')").length == 2) // together with a paragraph created by scalajs-dom
    }

    test("ButtonClick") {
      def messageCount =
        document.querySelectorAll("p").count(_.textContent == "You clicked the button!")

      val button = document.querySelector("button").asInstanceOf[dom.html.Button]
      assert(button != null && button.textContent == "Click me!")
      assert(messageCount == 0)

      for (c <- 1 to 5) {
        button.click()
        assert(messageCount == c)
      }
    }

    test("Click me (jQuery)") {
      def messageCount =
        jQuery("p:contains('You clicked the jQuery button!')").length

      val button = jQuery("button:contains('Click me (jQuery)')")
      assert(button != null && button.text() == "Click me (jQuery)")
      assert(messageCount == 0)

      for (c <- 1 to 5) {
        button.click()
        assert(messageCount == c)
      }
    }
  }
}
