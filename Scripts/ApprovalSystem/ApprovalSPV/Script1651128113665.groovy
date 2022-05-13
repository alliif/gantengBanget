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
	
	String noRekening = data.getValue('noRek',i)
	String hasilRek = noRekening.substring(12,13)
	
    if (hasilRek == '5') {
        WebUI.scrollToElement(findTestObject('TarikTunai/ApprovalSystem'), 2)
    } else if (hasilRek == '3') {
        WebUI.scrollToElement(findTestObject('TarikTunai/approval SystemCA'), 2)
    }
}

WebUI.click(findTestObject('Object Repository/New Denom/div_Tipe Approval_q-field__native row items-center'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/New Denom/div_Local'))

WebUI.delay(1)

WebUI.click(findTestObject('TarikTunai/inputSPV'))

WebUI.setText(findTestObject('TarikTunai/inputSPV'), '0206258')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('TarikTunai/inputSPV'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

WebUI.delay(1)

for (int i = 1; i <= data.getRowNumbers(); i++) {
	
	String noRekening = data.getValue('noRek',i)
	String hasilRek = noRekening.substring(12,13)
	
    if (hasilRek == '5') {
		WebUI.scrollToElement(findTestObject('approve/spanApprove'), 2)
		
		WebUI.delay(1)
		
        WebUI.click(findTestObject('approve/spanApprove'))

        WebUI.delay(1)

        WebUI.click(findTestObject('TarikTunai/inputPasswordSPV'))

        WebUI.delay(1)

        WebUI.setText(findTestObject('TarikTunai/inputPasswordSPV'), '22222222')

        WebUI.delay(1)

        WebUI.click(findTestObject('TarikTunai/btnSubmit'))

        WebUI.delay(1)
    } else if (hasilRek == '3') {
		if(GlobalVariable.jenisMonetary == 'SetorTunai')
		{
			WebUI.scrollToElement(findTestObject('approve/spanApprove'), 2)
			
			WebUI.delay(1)
			
			WebUI.click(findTestObject('approve/spanApprove'))
	
			WebUI.delay(1)
	
			WebUI.click(findTestObject('TarikTunai/inputPasswordSPV'))
	
			WebUI.delay(1)
	
			WebUI.setText(findTestObject('TarikTunai/inputPasswordSPV'), '22222222')
	
			WebUI.delay(1)
	
			WebUI.click(findTestObject('TarikTunai/btnSubmit'))
	
			WebUI.delay(1)
		} else {
			WebUI.scrollToElement(findTestObject('TarikTunai/btnApproveCA'), 2)
			
			WebUI.delay(1)
			
			WebUI.click(findTestObject('TarikTunai/btnApproveCA'))
	
			WebUI.delay(1)
	
			WebUI.click(findTestObject('TarikTunai/inputPasswordSPV'))
	
			WebUI.delay(1)
	
			WebUI.setText(findTestObject('TarikTunai/inputPasswordSPV'), '22222222')
	
			WebUI.delay(1)
	
			WebUI.click(findTestObject('TarikTunai/rekCA/btnShowSVS'))
	
			WebUI.delay(5)
	
			WebUI.click(findTestObject('TarikTunai/rekCA/btnCloseSVS'))
	
			WebUI.delay(2)
	
			WebUI.click(findTestObject('TarikTunai/rekCA/span_Submit'))
	
			WebUI.delay(1)
		}
		
    }
}

