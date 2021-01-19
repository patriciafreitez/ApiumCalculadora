package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import page.Calculadora1;
import report.ReportManager;
import resources.Configuracion;
import util.AssertUtil;

public class TestRaizNegativa {

	private ReportManager reportManager;
	private WebDriver driver;
	Calculadora1 Calculadora1;
	
	@Before
	public void setUp() throws Exception {
		reportManager = new ReportManager();		
		Configuracion config = new Configuracion();
		driver = config.driverConnection();
		Calculadora1 = new Calculadora1(driver);
	}

	@Test
	public void test() throws Exception {
		int test = reportManager.registerTest("Raiz negativa");
		String text = Calculadora1.raizNegativa();		
		AssertUtil.assertEquals(text, "No es número.", test);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


}
