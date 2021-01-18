package testng.listeners;

import base.BaseApi;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentReport;
import java.io.IOException;


public class TestNGListeners extends BaseApi implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReport.getExtentReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.get().log(Status.PASS,"Test Passed");

    }

    public void onTestFailure(ITestResult iTestResult) {
        extentTest.get().fail(iTestResult.getThrowable());
        String methodName = iTestResult.getMethod().getMethodName();
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(methodName),iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
            }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        extent.flush();

    }
}
