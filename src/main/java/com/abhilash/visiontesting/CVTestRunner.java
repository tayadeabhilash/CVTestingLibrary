package com.abhilash.visiontesting;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class CVTestRunner {
    private final List<XmlSuite> suites;

    public CVTestRunner() {
        this.suites = new ArrayList<>();
    }

    public void addSuite(String suiteName, String className) {
        XmlSuite suite = new XmlSuite();
        suite.setName(suiteName + " Suite");

        XmlTest test = new XmlTest(suite);
        test.setName(suiteName);

        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass(className));
        test.setXmlClasses(classes);

        suite.setFileName("cvtests.xml");
        suite.setVerbose(1);

        suites.add(suite);
    }

    public void runTests() {
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(this.suites);
        testNG.setListenerClasses(List.of(TestFailureListener.class));
        testNG.run();
    }
}
