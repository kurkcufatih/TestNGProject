package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    public void onStart(ITestContext arg) {
        System.out.println("onStart -Tum testlerden ONCE 1 sefer cagirilir =>" + arg.getName());
    }

    @Override
    public void onFinish(ITestContext arg) {
        System.out.println("onFinish - Tum testlerden SONRA 1 sefer cagirili =>" + arg.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Method sayisi kadar, Her bir @Test annotationdan once bir kez calisir =>" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - PASS olan method sayisi kadar, pass edilen methodlardan SONRA bir kez calisir =>" + result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Skipped edilen Method sayisi kadar, ve skipped edilen methodlardan SONRA bir kez calisir =>" + result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println("onTestFailed - Failed edilen method sayisi kadar, ve failed  edilen methodlardan SONRA bir kez calisir=>" + result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
