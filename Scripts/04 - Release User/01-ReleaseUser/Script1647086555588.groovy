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

WebUI.click(findTestObject('Release User/span_inventory_2Administrasi                Baru'))

WebUI.delay(1)

WebUI.click(findTestObject('Release User/div_Release User'))

WebUI.delay(1)

TestData data = findTestData('ReleaseUser')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    String userID = data.getValue('UserID', i)

    WebDriver driver = DriverFactory.getWebDriver()

    WebElement Table = driver.findElement(By.xpath('//table/tbody'))

    List<WebElement> Rows = Table.findElements(By.tagName('tr'))

    WebUI.delay(1)

    for (int k = 0; k < Rows.size(); k++) {
        List<WebElement> Cols = Rows.get(k).findElements(By.tagName('td'))

        for (int j = 0; j < Cols.size(); j++) {
            if (Cols.get(j).getText().equalsIgnoreCase(userID)) {
                //          Cols.get(2).findElement(By.xpath("//input")).click()
                String total = k + 1

                String xpath = ('tr[' + total) + ']/td/div/div'

                System.print(('***' + k) + '****')

                Cols.get(2).findElement(By.xpath(('//' + xpath) + '')).click()

                break
            }
        }
    }
}

WebUI.delay(1)

WebUI.click(findTestObject('Release User/span_Submit'))

WebUI.delay(1)

WebUI.click(findTestObject('Release User/span_Ok'))

WebUI.delay(1)

WebUI.click(findTestObject('Release User/btnSukses'))

WebUI.delay(2)

