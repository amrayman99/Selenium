package Util;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class TestNG_Listener extends BaseTest implements ITestListener {
    public TestNG_Listener() throws IOException {
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName=result.getName();
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File("./ScreenShots/"+methodName+".png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test case ' " +methodName+ " ' has failed and screenshot has been taken.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
