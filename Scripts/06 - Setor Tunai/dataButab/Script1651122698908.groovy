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

TestData tlnobk = findTestData('TLNOBK')

for (int i = 1; i <= tlnobk.getRowNumbers(); i++) {
    WebUI.click(findTestObject('SetorTunai/noButab'))

    WebUI.setText(findTestObject('SetorTunai/noButab'), tlnobk.getValue('noButab', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('SetorTunai/saldoButab'))

    WebUI.setText(findTestObject('SetorTunai/saldoButab'), tlnobk.getValue('saldoButab', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('SetorTunai/barisButab'))

    WebUI.setText(findTestObject('SetorTunai/barisButab'), tlnobk.getValue('barisButab', i))

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SetorTunai/barisButab'), Keys.chord(Keys.ENTER))

    WebUI.delay(1)
}

