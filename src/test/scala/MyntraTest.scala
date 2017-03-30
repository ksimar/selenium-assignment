
import java.util.concurrent.TimeUnit

import org.apache.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.FlatSpec
import org.openqa.selenium.support.ui.Select


class MyntraTest extends FlatSpec with TestSetUp{

  val log = Logger.getLogger(this.getClass)

  "A user" should "visit on myntra.com" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
    if (driver.getCurrentUrl == BASE_URL) {
      println("WELCOME TO Myntra.com with title : " + title)
      println("the length of the pagesource is: " + page_source)
    } else {
      println("something went wrong")
    }
  }

  "user" should "logged in " in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()
   // driver.findElementByCssSelector("span.myntraweb-sprite desktop-caret sprites-caret").click()
    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()
    driver.findElementByCssSelector("input.login-user-input-email").sendKeys(EMAIl)
    driver.findElementByCssSelector("input.login-user-input-password").sendKeys(password)
    driver.findElementByCssSelector("button.login-login-button").click()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    Thread.sleep(5000)
  }

  "user" should "search for bag and add to cart" in {
    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val search = driver.findElementByCssSelector("input.desktop-searchBar")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(search)
    mouseHover.build().perform()
    log.info("Hovered on search")
    driver.findElementByCssSelector("input.desktop-searchBar").sendKeys(ITEM)
    driver.findElementByCssSelector("a.desktop-submit").click()

    val selectedItem1 = driver.findElementByCssSelector("ul.results-base > li:nth-child(5)")
//    val mouseHoverToItem = new Actions(driver)
//    mouseHoverToItem.moveToElement(selectedItem)
//    mouseHoverToItem.build().perform()
//    driver.findElementByCssSelector("div.product-actions > (span.product-actionsButton span.product-addToBag): nth-child(5)").click()
//
    selectedItem1.click()
    driver.findElementByCssSelector("button.pdp-add-to-bag").click()
    log.info("Item added to cart")
  }

  "user" should "select second bag and add it to cart" in {
    driver.findElementByCssSelector("input.desktop-searchBar").sendKeys(ITEM)
    driver.findElementByCssSelector("a.desktop-submit").click()
    val selectedItem2 = driver.findElementByCssSelector("ul.results-base > li:nth-child(1)")
    selectedItem2.click()
    driver.findElementByCssSelector("button.pdp-add-to-bag").click()
    log.info("Item added to cart")
  }

  "user" should "be able to see all items added to cart" in {
    
  }
}
