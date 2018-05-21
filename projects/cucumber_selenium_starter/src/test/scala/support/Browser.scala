package support

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser

trait Browser extends WebBrowser {
  implicit val webDriver: WebDriver = new ChromeDriver()
//  sys.addShutdownHook(webDriver.close())
}
