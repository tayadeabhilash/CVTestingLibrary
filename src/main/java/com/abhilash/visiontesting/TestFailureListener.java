package com.abhilash.visiontesting;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestFailureListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            System.out.println("Test method '" + method.getTestMethod().getMethodName() + "' failed!");
            System.out.println("Failure Reason: " + testResult.getThrowable().getMessage());
        }
    }
}

