package principal;

import org.junit.runner.JUnitCore;

import report.ReportManager;

public class Main {

	public static void main(String[] args) {
		ReportManager reportManager = new ReportManager();
		reportManager.init("Calculadora");
		
		JUnitCore.runClasses(Principal.class);
		
		reportManager.closeReport();
	}

}
