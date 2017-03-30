import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait

trait TestSetUp {

  val BASE_URL = "http://www.myntra.com/"
  val EMAIl = "simarkaurcs@gmail.com"
  val password = "simar123"
  val INVALIDPASSWORD = "abc"
  val ITEM = "women bag"
  System.setProperty("webdriver.chrome.driver", "/home/simar/Desktop/chromedriver")
  val capabilities = DesiredCapabilities.chrome()
  val driver = new ChromeDriver(capabilities)
  val webdriverwait = new WebDriverWait(driver, 10)



}