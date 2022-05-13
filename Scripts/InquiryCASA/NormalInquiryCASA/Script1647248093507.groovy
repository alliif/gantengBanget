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

WebUI.click(findTestObject('InquiryCASA/Page_New Delivery System/Non Finansial'))

WebUI.delay(1)

WebUI.click(findTestObject('InquiryCASA/Page_New Delivery System/Inquiry Account CASA'))

WebUI.delay(1)

WebUI.refresh()

WebUI.delay(1)

WebUI.sendKeys(findTestObject('InquiryCASA/Page_New Delivery System/noRek'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('InquiryCASA/Page_New Delivery System/noRek'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('InquiryCASA/Page_New Delivery System/noRek'), '020601181838500')

WebUI.click(findTestObject('InquiryCASA/Page_New Delivery System/btnCari'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('InquiryCASA/Page_New Delivery System/Page_New Delivery System/FieldSaldo'), 2)

WebUI.delay(10)

