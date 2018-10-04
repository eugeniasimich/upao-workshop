package uitests

import org.scalatest.selenium.Firefox

class UserSpec1 extends CommonSelenium with Firefox {

  "slash" should "redirect to index.html" in {
    go to baseUrl

    currentUrl should be(baseUrl)

    find(cssSelector("#welcome-page > h1")).get.text should be("Welcome to our test page!")

    find(className("button-login")).get.text should be("Login")
  }
}
