package uitests

import scala.collection.JavaConversions._
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import org.scalatest.selenium.Firefox
import org.scalatest.Matchers
import org.scalatest.concurrent.IntegrationPatience

class WhatIsBonzzu extends Eventually with WebBrowser with Firefox with Matchers with IntegrationPatience {

  def fn(): Unit = {
    println("Yay, we are famous 12312")
    try {
      go to "http://www.google.com/"

      textField("q").value = "Bonzzu"
      click on "btnG"

      eventually {
        find(tagName("body")).get.text should include("bonzzu.com")
      }

      println("Yay, we are famous")
    } finally {
      webDriver.quit()
    }
  }
}

object WhatIsBonzzu extends App {
  println("Yay, we are famous 1122")
  new WhatIsBonzzu().fn()
  println("Yay, we are famous 123122")
}
