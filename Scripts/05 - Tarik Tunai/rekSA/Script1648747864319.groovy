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
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory

TestData data = findTestData('TarikTunai')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/inputNominal'))

    WebUI.setText(findTestObject('TarikTunai/inputNominal'), data.getValue('nominal', i))

    WebUI.delay(1)

    WebUI.scrollToElement(findTestObject('TarikTunai/inputNoHandphone'), 2)

    WebUI.delay(1)

    WebUI.click(findTestObject('TarikTunai/inputNoHandphone'))

    WebUI.setText(findTestObject('TarikTunai/inputNoHandphone'), data.getValue('noHP', i))

    WebUI.delay(1)
	
	String noRekening = data.getValue('noRek', i)
	
	String hasilRek = noRekening.substring(12, 14)
	
	//Jika rekening Britama Bisnis
	if (hasilRek == '56') {
		WebUI.callTestCase(findTestCase('Python/TlnobkCek'), null)
		
		WebUI.delay(44)
		
		WebUI.callTestCase(findTestCase('05 - Tarik Tunai/britamaBisnis'), null)
		
		WebUI.delay(1)
		
	}
	//jika rekening SA biasa
	else {
		WebUI.click(findTestObject('TarikTunai/spanPrint'))
		
			WebUI.delay(1)
		
			WebUI.click(findTestObject('TarikTunai/btnOK_Konfirmasi'))
		
			WebUI.delay(1)
		
			//Remote Print Agent
			WebUI.callTestCase(findTestCase('AgentRemote/BaxPrint'), null)
		
			WebUI.scrollToElement(findTestObject('TarikTunai/inputNoButab'), 2)
		
			WebUI.delay(1)
		
			WebUI.callTestCase(findTestCase('Python/TlnobkCek'), null)
		
			WebUI.delay(44)
		
			WebUI.callTestCase(findTestCase('05 - Tarik Tunai/dataButab'), null)
		
			WebUI.delay(1)
	}
}

