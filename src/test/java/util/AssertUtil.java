package util;

import org.junit.Assert;

import report.ReportManager;

public class AssertUtil {
	
	static public void assertEquals(int testValue, int expected, int testPos) {
		ReportManager reportManager = new ReportManager();
		if (testValue == expected) {
			reportManager.testPassed(testPos);
		} else {
			reportManager.testFailed(testPos);
		}
		Assert.assertEquals(testValue, expected);
	}
	
	static public void assertEquals(String testValue, String expected, int testPos) {
		ReportManager reportManager = new ReportManager();
		if (testValue.equals(expected)) {
			reportManager.testPassed(testPos);
		} else {
			reportManager.testFailed(testPos);
		}
		Assert.assertEquals(testValue, expected);
	}

}
