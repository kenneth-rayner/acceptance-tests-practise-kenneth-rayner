package steps

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import support.Browser

import collection.JavaConverters._
import scala.language.postfixOps


class StepDefinitions extends ScalaDsl with EN with Matchers with Browser {

  Given("""^I am on the Social Care Compliance homepage$""") { () =>
    go to "http://localhost:8550/apply-for-social-care-compliance-scheme/capacity-registering"
    find(cssSelector("h1")).get.text shouldBe "Which of these options best describes you?"
  }
  When("""^I choose the "Someone who pays for care directly" option$""") { () =>
    click on id("capacityRegistering.personalBudgetHolderDirect")
    click on id("submit")
  }

  When("""^I choose the "An agent or representative of someone who pays for care directly" option$""") { () =>
    click on id("capacityRegistering.personalBudgetHolderAgent")
    click on id("submit")
  }
  When("""^I choose the "A company that employs social care worker" option$""") { () =>
    click on id("capacityRegistering.companyEmployeeOrDirector")
    click on id("submit")
  }
  And("""^I enter my company name as "(.+)"$""") {(companyName:String) =>
    //  textField("value").value = "Ken"

    //or alternatively
    webDriver.findElement(By.id("value")).sendKeys(companyName)
    webDriver.findElement(By.id("submit")).click()
    //click on id("submit")
  }

  And("""^I choose the "Yes" option$"""){ () =>
    click on id("value-yes")
    click on id("submit")

  }
  And("""^I choose the "Continue" option$"""){ () =>
    click on id("submit")

  }

  And("""^I enter my name as "(.+)"$""") {( name:String) =>
    //  textField("value").value = "Ken"

    //or alternatively
    webDriver.findElement(By.id("value")).sendKeys(name)
    webDriver.findElement(By.id("submit")).click()
    //click on id("submit")
  }

  And("""^My address is in the UK$""") { () =>
    radioButtonGroup("value").value = "true"
    click on id("submit")
  }
  // alternatively:
  // click on id("value-yes")

  //     And("""^My address is 'Line 1,Line 2,NE99 1AZ'""") { () =>
  //        textField("addressLine1").value = "Line 1"
  //        textField("addressLine2").value = "Line 2"
  //        textField("postcode").value = "NE99 1AZ"
  //        click on id("submit")
  //      }

  And("""^I enter my address as$""") { (table: DataTable) =>
    table.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach(row => {
      webDriver.findElement(By.name(row.get("Field"))).sendKeys(row.get("Value"))
    })
    click on id("submit")
  }

  And("""^I enter my phone number as (.+)$""")  { number: String =>
    //    textField("value").value = "12345"
    //    click on id("submit")
    webDriver.findElement(By.id("value")).sendKeys(number)
    webDriver.findElement(By.id("submit")).click()
  }

  And("""^I don't have an e-mail address$""") { () =>
    radioButtonGroup("value").value = "false"
    click on id("submit")
  }

  And("""^I don't have a UTR number$""") { () =>
    radioButtonGroup("value").value = "false"
    click on id("submit")
  }
  And("""^I don't have a PAYE reference number$""") { () =>
    radioButtonGroup("value").value = "false"
    click on id("submit")
  }

  And("""^I will be shown my answers$""") {(table: DataTable) =>
    webDriver.findElements(By.className("tabular-data__entry")).forEach(e =>
      println(e.getText))
    //
    //        table.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach(row => {
    //
    //        })
    click on id("submit")

  }
  Then("""^I will receive a confirmation that form has been submitted$""") { () =>
    find(cssSelector("h1")).get.text shouldBe "Application received"
  }
}
