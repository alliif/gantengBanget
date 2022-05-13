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

WebUI.click(findTestObject('TarikTunai/btnFinansial'))

WebUI.delay(1)

WebUI.click(findTestObject('SetorTunai/setorTunaiMUI'))

WebUI.delay(1)

WebUI.refresh()

WebUI.delay(2)

TestData data = findTestData('SetorTunai')

for (int i = 1; i <= data.getRowNumbers(); i++) {
	GlobalVariable.jenisMonetary = 'SetorTunai'
	GlobalVariable.noRekTLNOBK = data.getValue('noRek',i)
	String noRekening = data.getValue('noRek', i)
	String hasilRek = noRekening.substring(12, 13)
	String jenisTransaksi = data.getValue('jenisTransaksi', i)
    
    WebUI.click(findTestObject('SetorTunai/inputNoRek'))

    WebUI.setText(findTestObject('SetorTunai/inputNoRek'), data.getValue('noRek', i))

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SetorTunai/inputNoRek'), Keys.chord(Keys.TAB))

    WebUI.delay(6)
	
    if (hasilRek == '5') {
			if (jenisTransaksi == 'Buku Tabungan') {
				WebUI.click(findTestObject('SetorTunai/spanButab'))
			} else if (jenisTransaksi == 'Tanpa Buku Tabungan') {
				WebUI.click(findTestObject('SetorTunai/spanTanpaButab'))
			}
		WebUI.delay(1)
        WebUI.callTestCase(findTestCase('06 - Setor Tunai/rekSA'), null)
    } else if (hasilRek == '3') {
        WebUI.callTestCase(findTestCase('06 - Setor Tunai/rekCA'), null)
    }
    
    WebUI.callTestCase(findTestCase('ApprovalSystem/ApprovalSPV'), null)

    WebUI.delay(2)

    if (hasilRek == '5') {
        // Tapak Validasi
        WebUI.click(findTestObject('RemoteAgent/TapakValidasi/spanTapakValidasi'))
        WebUI.delay(1)
		
        //Remote Print Agent
        WebUI.callTestCase(findTestCase('AgentRemote/printTapakValidasi'), null)

        WebUI.delay(2)
		
		if (jenisTransaksi == 'Buku Tabungan') {
			WebUI.click(findTestObject('RemoteAgent/Butab/spanButab'))
			WebUI.callTestCase(findTestCase('AgentRemote/printBukuTabungan'), null)
		}
        WebUI.delay(2)
		
        //		Call AATR
        WebUI.callTestCase(findTestCase('Python/AATR'), [:], FailureHandling.STOP_ON_FAILURE)
		
    } else if (hasilRek == '3') {
        WebUI.delay(1)

        WebUI.takeScreenshot()

        WebUI.delay(1)

        WebUI.click(findTestObject('RemoteAgent/TapakValidasi/spanTapakValidasi'))

        WebUI.callTestCase(findTestCase('AgentRemote/printTapakValidasi'), null)

        WebUI.callTestCase(findTestCase('Python/AATR'), [:], FailureHandling.STOP_ON_FAILURE)
    }
}

