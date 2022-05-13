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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.awt.Robot as Robot

String popText = WebUI.getText(findTestObject('Popup PN/div_Informasi Login'))
if(popText.contains("Informasi Login"))
{
	WebUI.click(findTestObject('Object Repository/Popup PN/span_OK'))
}
else
{
	WebUI.refresh()
}

WebUI.click(findTestObject('Page_New Delivery System/span_inventory_2Administrasi                Baru'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_New Delivery System/div_Maintenance Denomination Micro UI'))

WebUI.delay(2)

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

TestData data = findTestData('MaintenanceDenomination')

for (int k = 1; k <= data.getRowNumbers(); k++) {
    String denom = data.getValue('denomination', k)

    String jenis = data.getValue('jenis_uang', k)

    WebDriver driver = DriverFactory.getWebDriver()

    WebElement Table = driver.findElement(By.xpath('//table/tbody'))

    List<WebElement> Rows = Table.findElements(By.tagName('tr'))

    WebUI.delay(2)

    for (int i = 0; i < Rows.size(); i++) {
        List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

        for (int j = 0; j < Cols.size(); j++) {
            if (Cols.get(j).getText().equalsIgnoreCase(denom) && Cols.get(j + 1).getText().equalsIgnoreCase(jenis)) {
                Cols.get(2).findElement(By.tagName('i')).click()

                break
            }
        }
        
        if (WebUI.verifyTextNotPresent('Tambah Denominasi', false, FailureHandling.OPTIONAL) == true) {
            break
        }
    }
    
    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Object Repository/New Denom/div_Tipe Approval_q-field__native row items-center'), 
        0)

    WebUI.click(findTestObject('Object Repository/New Denom/div_Tipe Approval_q-field__native row items-center'))

    if (data.getValue('tipe_approval', k) == 'Local') {
        WebUI.click(findTestObject('Object Repository/New Denom/div_Local'))

        WebUI.delay(1)
    } else {
        WebUI.click(findTestObject('Object Repository/New Denom/div_Remote'))

        WebUI.delay(1)
    }

    WebUI.click(findTestObject('New Denom/input_ID Supervisor_listSupervisor'))
	
	WebUI.delay(1)

    WebUI.setText(findTestObject('New Denom/input_ID Supervisor_listSupervisor'), GlobalVariable.approval_spv)

    WebUI.delay(3)

    WebUI.sendKeys(findTestObject('New Denom/input_ID Supervisor_listSupervisor'), Keys.chord(Keys.DOWN, Keys.ENTER))

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    switch (data.getValue('tipe_approval', k)) {
        case 'Local':
			WebUI.delay(1)
			
            WebUI.click(findTestObject('Object Repository/approve/span_Approve'))
			
            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/New Denom/span_Ok'))

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/New Denom/input_Masukkan Kata Sandi_passwordApproval'))

            WebUI.delay(1)

            WebUI.setText(findTestObject('Object Repository/New Denom/input_Masukkan Kata Sandi_passwordApproval'), GlobalVariable.pass_approval)

            WebUI.delay(2)

            WebUI.sendKeys(findTestObject('Object Repository/New Denom/input_Masukkan Kata Sandi_passwordApproval'), Keys.chord(Keys.ENTER))

            WebUI.delay(1)

            break
    }
    
    WebUI.verifyTextPresent(data.getValue('validasi', k), false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/approve/span_Finish'))
	
    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(2)
}

