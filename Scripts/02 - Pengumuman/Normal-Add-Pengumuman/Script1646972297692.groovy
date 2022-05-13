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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.awt.Robot as Robot

String popText = WebUI.getText(findTestObject('Popup PN/div_Informasi Login'))

if (popText.contains('Informasi Login')) {
    WebUI.click(findTestObject('Object Repository/Popup PN/span_OK'))
} else {
    WebUI.refresh()
}

WebUI.click(findTestObject('Pengumuman/span_topicGeneral'))

WebUI.delay(1)

WebUI.click(findTestObject('Pengumuman/div_Announcement Setting Micro UI'))

WebUI.delay(2)

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Pengumuman/span_Tambah Pengumuman'))

WebUI.delay(1)

TestData data = findTestData('Pengumuman')

for (int i = 1; i <= data.getRowNumbers(); i++) {
    WebUI.click(findTestObject('Pengumuman/input_Judul Pengumuman_judulPengumuman'))

    WebUI.setText(findTestObject('Pengumuman/input_Judul Pengumuman_judulPengumuman'), data.getValue('judul', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('Pengumuman/date'))

    WebUI.delay(1)

    String dataMonth = WebUI.getText(findTestObject('Pengumuman/Months'))

    String dataYear = WebUI.getText(findTestObject('Pengumuman/Years'))

    //Buat Tanggal Awal
    String tgl_awal = data.getValue('tgl_awal', i)

    String tanggal = tgl_awal.split(' ')[0]

    String bulan = tgl_awal.split(' ')[1]

    String tahun = tgl_awal.split(' ')[2]

    while (!(dataMonth.equals(bulan))) {
        WebUI.click(findTestObject('Pengumuman/nextBtn'))

        WebUI.delay(1)

        dataMonth = WebUI.getText(findTestObject('Pengumuman/Months'))
    }
    
    while (!(dataYear.equals(tahun))) {
        WebUI.click(findTestObject('Pengumuman/btnNextYear'))

        WebUI.delay(1)

        dataYear = WebUI.getText(findTestObject('Pengumuman/Years'))
    }
    
    WebDriver driver = DriverFactory.getWebDriver()

    List<WebElement> DatePicker = driver.findElements(By.xpath('//div[@class=\'q-date__calendar-item q-date__calendar-item--in\']'))

    WebUI.delay(1)

    for (WebElement e : DatePicker) {
        if (e.getText().equals(tanggal)) {
            e.click()

            break
        }
    }
    
    WebUI.delay(1)

    WebUI.click(findTestObject('Pengumuman/Closed'))

    WebUI.delay(1)

    //End Tanggal Awal
    //Buat Tanggal Akhir
    WebUI.click(findTestObject('Pengumuman/lastDate'))

    WebUI.delay(1)

    String dataMonthEnd = WebUI.getText(findTestObject('Pengumuman/bulan_akhir'))

    String tgl_awalEnd = data.getValue('tgl_akhir', i)
    String tanggalEnd = tgl_awalEnd.split(' ')[0]
    String bulanEnd = tgl_awalEnd.split(' ')[1]
    String tahunEnd = tgl_awalEnd.split(' ')[2]

    while (!(dataMonthEnd.equals(bulanEnd))) {
        WebUI.click(findTestObject('Pengumuman/nextBtnMonthEnd'))
        WebUI.delay(1)
        dataMonthEnd = WebUI.getText(findTestObject('Pengumuman/bulan_akhir'))
    }
	String dataYearEnd = WebUI.getText(findTestObject('Pengumuman/tahun_akhir'))
	
    while (!(dataYearEnd.equals(tahunEnd))) {
        WebUI.click(findTestObject('Pengumuman/nextBtnYearEnd'))
        WebUI.delay(1)
        dataYearEnd = WebUI.getText(findTestObject('Pengumuman/tahun_akhir'))
    }
    
	WebDriver driverEnd = DriverFactory.getWebDriver()
    List<WebElement> DatePickerEnd = driverEnd.findElements(By.xpath('//div[@class=\'q-date__calendar-item q-date__calendar-item--in\']'))
	
    WebUI.delay(1)

    for (WebElement e : DatePickerEnd) {
        if (e.getText().equals(tanggalEnd)) {
            e.click()

            break
        }
    }
    
    WebUI.delay(1)

    //End Tanggal Akhir
    WebUI.click(findTestObject('Pengumuman/Closed'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Pengumuman/div_Deskripsi Pengumuman_q-editor__content bg-yellow-2'))

    WebUI.setText(findTestObject('Object Repository/Pengumuman/div_Deskripsi Pengumuman_q-editor__content bg-yellow-2'), 
        data.getValue('deskripsi', i))

    WebUI.delay(1)

    WebUI.click(findTestObject('Pengumuman/span_Submit'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Pengumuman/span_Ok'))

    WebUI.delay(3)
}

