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
if(popText.contains("Informasi Login"))
{
	WebUI.click(findTestObject('Object Repository/Popup PN/span_OK'))
}
else
{
	WebUI.refresh()
}

WebUI.click(findTestObject('Mapping PN User/input_Baru_f_6d5f837a-005b-443b-9e3c-529536192ee2'))

WebUI.setText(findTestObject('Mapping PN User/input_Baru_f_6d5f837a-005b-443b-9e3c-529536192ee2'), 'Mapping User ID And PN')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Mapping PN User/input_Baru_f_6d5f837a-005b-443b-9e3c-529536192ee2'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.click(findTestObject('Mapping PN User/span_update              Mapping User ID and PN Micro UI'))

WebUI.delay(1)

WebUI.refresh()

TestData data = findTestData('MappingPNuserID')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.sendKeys(findTestObject('Mapping PN User/input_PN_noPN'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Mapping PN User/input_PN_noPN'), Keys.chord(Keys.BACK_SPACE))

    WebUI.setText(findTestObject('Mapping PN User/input_PN_noPN'), data.getValue('PN', i))

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('Mapping PN User/input_PN_noPN'), Keys.chord(Keys.ARROW_DOWN))

    WebUI.sendKeys(findTestObject('Mapping PN User/input_PN_noPN'), Keys.chord(Keys.ENTER))

    WebUI.delay(1)

    WebUI.click(findTestObject('Mapping PN User/input_Password BRIStars_sandi'))

    WebUI.setText(findTestObject('Mapping PN User/input_Password BRIStars_sandi'), data.getValue('Password', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('Mapping PN User/input_Ketik Ulang Password BRIStars_sandiConfirm'))

    WebUI.setText(findTestObject('Mapping PN User/input_Ketik Ulang Password BRIStars_sandiConfirm'), data.getValue('KonfirmasiPassword', 
            i))

    WebUI.delay(1)

    WebUI.click(findTestObject('Mapping PN User/span_Submit'))

    WebUI.delay(1)

    WebUI.refresh()
}

