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

TestData data = findTestData('TarikTunai')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/rekCA/inputNominal'))

    WebUI.setText(findTestObject('TarikTunai/rekCA/inputNominal'), data.getValue('nominal', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/rekCA/inputBiaya'))

    WebUI.sendKeys(findTestObject('TarikTunai/rekCA/inputBiaya'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('TarikTunai/rekCA/inputBiaya'), Keys.chord(Keys.BACK_SPACE))

    WebUI.setText(findTestObject('TarikTunai/rekCA/inputBiaya'), data.getValue('biaya', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/rekCA/inputNoHandphone'))

    WebUI.setText(findTestObject('TarikTunai/rekCA/inputNoHandphone'), data.getValue('noHP', i))

    WebUI.delay(1)

//    WebUI.click(findTestObject('TarikTunai/inputKeterangan'))
//
//    WebUI.setText(findTestObject('TarikTunai/inputKeterangan'), data.getValue('keterangan', i))
//
//    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('TarikTunai/rekCA/tipeWarkat'), 2)

    WebUI.delay(2)

    if (WebUI.verifyTextPresent('CEK', false, FailureHandling.OPTIONAL) == true) {
        if (WebUI.verifyMatch('RECEIPT', data.getValue('jenisWarkat', i), false, FailureHandling.OPTIONAL) == true) {
            WebUI.click(findTestObject('TarikTunai/rekCA/warkatReceipt'))

            WebUI.delay(1)
        }
    }
    
    WebUI.delay(1)

    WebUI.takeFullPageScreenshot()

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('TarikTunai/rekCA/spanPrint'), 2)

    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/rekCA/spanPrint'))

    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/rekCA/OKprintAgent'))

    WebUI.delay(1)

    //Remote Print Agent
    WebUI.callTestCase(findTestCase('AgentRemote/BaxPrint'), null)

    WebUI.delay(7)

    WebUI.click(findTestObject('TarikTunai/rekCA/acceptSVS'))

    WebUI.delay(1)
}

