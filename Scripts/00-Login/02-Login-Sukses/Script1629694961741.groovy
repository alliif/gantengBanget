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

WebUI.sendKeys(findTestObject('LoginPage/input_Masukkan nama user dan kata sandi_useridsso'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('LoginPage/input_Masukkan nama user dan kata sandi_useridsso'), Keys.chord(Keys.BACK_SPACE))

//WebUI.click(findTestObject('LoginPage/input_Masukkan nama user dan kata sandi_useridsso'))
WebUI.setText(findTestObject('LoginPage/input_Masukkan nama user dan kata sandi_useridsso'), GlobalVariable.user_teller)

WebUI.doubleClick(findTestObject('LoginPage/input_User ID salah_passwordsso'))

WebUI.sendKeys(findTestObject('LoginPage/input_User ID salah_passwordsso'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('LoginPage/input_User ID salah_passwordsso'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('LoginPage/input_User ID salah_passwordsso'), GlobalVariable.password_teller)

WebUI.takeFullPageScreenshot()

WebUI.delay(1)

WebUI.click(findTestObject('Page_New Delivery System/span_Login'))

WebUI.delay(2)

