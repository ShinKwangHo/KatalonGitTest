import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common Test Case/Login'), [('var_username') : var_username, ('var_password') : var_password], 
    FailureHandling.STOP_ON_FAILURE)

switch (var_StatusExpectedResult.toString()) {
    case 'Password cannot be empty':
        def errorMess = WebUI.getText(findTestObject('Object Repository/Main Test Case_Verify Login/span_Password cannot be empty'))

        WebUI.verifyEqual(errorMess.contains('Password cannot be empty'), true)

        break
    case 'Invalid credentials':
        def errorMess = WebUI.getText(findTestObject('Object Repository/Main Test Case_Verify Login/span_Invalid credentials'))

        WebUI.verifyEqual(errorMess.contains('Invalid credentials'), true)

        break
}

@com.kms.katalon.core.annotation.SetUp
def setup() {
    WebUI.openBrowser('http://opensource.demo.orangehrmlive.com/index.php/auth/login')
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    WebUI.closeBrowser()
}

