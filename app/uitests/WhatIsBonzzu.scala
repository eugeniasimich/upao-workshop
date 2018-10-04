package uitests

import scala.collection.JavaConversions._
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import org.scalatest.selenium.Firefox
import org.scalatest.Matchers
import org.scalatest.concurrent.IntegrationPatience

class WhatIsBonzzu extends Eventually with WebBrowser with Firefox with Matchers with IntegrationPatience {

  def fn(): Unit = {
    try {
      go to "http://www.google.com/"

      textField("q").value = "Bonzzu"
      click on name("btnK")

      eventually {
        find(tagName("body")).get.text should include("bonzzu.com")
      }

      println("###################################### Yay, we are famous ##########################################")
    } finally {
      webDriver.quit()
    }
  }
}

object WhatIsBonzzu extends App {
  System.setProperty("webdriver.gecko.driver",
    "drivers/geckodriver");
  new WhatIsBonzzu().fn()
}
