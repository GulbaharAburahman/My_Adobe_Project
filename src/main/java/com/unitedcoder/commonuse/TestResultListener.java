package com.unitedcoder.commonuse;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener implements ITestListener {
    List<ITestNGMethod> passedTests = new ArrayList<>();
    List<ITestNGMethod> failedTests = new ArrayList<>();
    List<ITestNGMethod> skippedTests = new ArrayList<>();
    List<ITestNGMethod> startedTests=new ArrayList<>();

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests.add(result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests.add(result.getMethod());
        FunctionLibrary.takeScreenShot(result.getMethod().getMethodName().trim(), (WebDriver) result.getTestContext().getAttribute("driver"));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests.add(result.getMethod());
    }

    @Override
    public void onTestStart(ITestResult result) {
        startedTests.add(result.getMethod());
    }



}
