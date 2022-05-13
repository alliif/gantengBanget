import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.awt.Robot as Robot

String popText = WebUI.getText(findTestObject('Popup PN/div_Informasi Login'))

if (popText.contains('Informasi Login')) {
    WebUI.click(findTestObject('Object Repository/Popup PN/span_OK'))
} else {
    WebUI.refresh()
}

WebUI.click(findTestObject('AATR/span_topicGeneral'))

WebUI.delay(1)

WebUI.click(findTestObject('AATR/div_AATR Micro UI'))

WebUI.delay(1)

WebUI.refresh()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('AATR/btnPrintAATR'), 2)

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('AATR/btnPrintAATR'), 2)

WebUI.delay(1)

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//table/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

String indexRow = Rows.size() - 1

System.print(('***' + indexRow) + '****')

String xpath = ('tr[' + indexRow) + ']/td[3]'

//String journalSeq = WebUI.getText(findTestObject('AATR/journalSequence'))
String journalSeq = driver.findElement(By.xpath('//' + xpath)).getText()

System.print(('***' + journalSeq) + '***')

GlobalVariable.journalSequence = journalSeq

WebUI.delay(2)

WebUI.callTestCase(findTestCase('Python/PuttyExecution'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(24)

