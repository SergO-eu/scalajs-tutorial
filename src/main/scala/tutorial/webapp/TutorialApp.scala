package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.jquery._

object TutorialApp {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })

    jQuery({() =>
      setupJQueryUI()
    })
  }

  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)

    appendPar(document.body, "Hello World")
  }

  def setupJQueryUI(): Unit = {
    val jqButton = jQuery("<button>Click me (jQuery)</button>")
      .on("click", () => jQuery("body").append("<p>You clicked the jQuery button!</p>"))
    jQuery("body").append(jqButton)

    jQuery("body").append("<p>Hello World (jQuery)<p>")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }
}
