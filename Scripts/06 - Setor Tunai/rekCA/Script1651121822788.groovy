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

TestData data = findTestData('SetorTunai')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.delay(1)

    WebUI.click(findTestObject('SetorTunai/inputJumlah'))

    WebUI.setText(findTestObject('SetorTunai/inputJumlah'), data.getValue('nominal', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('SetorTunai/inputSumberDana'))

    WebUI.setText(findTestObject('SetorTunai/inputSumberDana'), data.getValue('sumberDana', i))

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('SetorTunai/inputNamaPenyetor'), 2)

    WebUI.click(findTestObject('SetorTunai/inputNamaPenyetor'))

    WebUI.setText(findTestObject('SetorTunai/inputNamaPenyetor'), data.getValue('namaPenyetor', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('SetorTunai/inputNoHP'))

    WebUI.setText(findTestObject('SetorTunai/inputNoHP'), data.getValue('noHP', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('SetorTunai/inputKeterangan'))

    WebUI.setText(findTestObject('SetorTunai/inputKeterangan'), data.getValue('keterangan', i))

    WebUI.delay(1)
	
	WebUI.click(findTestObject('SetorTunai/spanPrint'))
	
	WebUI.delay(1)
	
	WebUI.click(findTestObject('TarikTunai/btnOK_Konfirmasi'))
	
	WebUI.delay(1)
	
	WebUI.callTestCase(findTestCase('AgentRemote/BaxPrint'), null)
}

