package com.Utilites;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }
}
