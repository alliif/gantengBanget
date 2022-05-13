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

String popText = WebUI.getText(findTestObject('Popup PN/div_Informasi Login'))

if (popText.contains('Informasi Login')) {
    WebUI.click(findTestObject('Object Repository/Popup PN/span_OK'))
} else {
    WebUI.refresh()
}

WebUI.click(findTestObject('Page_New Delivery System/span_inventory_2Administrasi                Baru'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_New Delivery System/div_Maintenance Denomination Micro UI'))

WebUI.delay(2)

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

TestData data = findTestData('MaintenanceDenomination')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.click(findTestObject('Object Repository/Denomination/input_Mata Uang_currency'))

    WebUI.setText(findTestObject('Object Repository/Denomination/input_Mata Uang_currency'), data.getValue('mata_uang', 
            i))

    WebUI.delay(3)

    WebUI.sendKeys(findTestObject('Object Repository/Denomination/input_Mata Uang_currency'), Keys.chord(Keys.DOWN, Keys.ENTER))

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Denomination/span_addTambah Denominasi'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Denomination/input_Denominasi_denomination'))

    WebUI.setText(findTestObject('Object Repository/Denomination/input_Denominasi_denomination'), data.getValue('denomination', 
            i))

    WebUI.delay(1)

    if (WebUI.verifyTextPresent('Kertas', false, FailureHandling.OPTIONAL) == true) {
        if (WebUI.verifyMatch('Koin', data.getValue('jenis_uang', i), false, FailureHandling.OPTIONAL) == true) {
            WebUI.takeScreenshot()

            WebUI.click(findTestObject('Object Repository/Page_New Delivery System/div_Koin'))

            WebUI.delay(1)
        }
    }
    
    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Denomination/span_addTambah'))

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Object Repository/Denomination/span_Preview'), 2)

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Denomination/span_Preview'))

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('Object Repository/New Denom/div_Tipe Approval_q-field__native row items-center'), 
        1)

    WebUI.click(findTestObject('Object Repository/New Denom/div_Tipe Approval_q-field__native row items-center'))

    if (data.getValue('tipe_approval', i) == 'Local') {
        WebUI.click(findTestObject('Object Repository/New Denom/div_Local'))

        WebUI.delay(1)
    } else {
        WebUI.click(findTestObject('Object Repository/New Denom/div_Remote'))

        WebUI.delay(1)
    }
    
    WebUI.click(findTestObject('Object Repository/Page_New Delivery System/input_ID Supervisor_listSupervisor'))

    WebUI.delay(1)

    WebUI.setText(findTestObject('Object Repository/Page_New Delivery System/input_ID Supervisor_listSupervisor'), GlobalVariable.approval_spv)

    WebUI.delay(3)

    WebUI.sendKeys(findTestObject('Object Repository/Page_New Delivery System/input_ID Supervisor_listSupervisor'), Keys.chord(
            Keys.DOWN, Keys.ENTER))

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    switch (data.getValue('tipe_approval', i)) {
        case 'Local':
            WebUI.click(findTestObject('Object Repository/Page_New Delivery System/span_Approve'))

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/New Denom/span_Ok'))

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/New Denom/input_Masukkan Kata Sandi_passwordApproval'))

            WebUI.delay(1)

            WebUI.setText(findTestObject('Object Repository/New Denom/input_Masukkan Kata Sandi_passwordApproval'), GlobalVariable.pass_approval)

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('New Denom/input_Masukkan Kata Sandi_passwordApproval'), Keys.chord(Keys.ENTER))

            WebUI.delay(1)

            break
    }
    
    WebUI.verifyTextPresent(data.getValue('validasi', i), false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/New Denom/span_Finish'))

    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(2)
}

