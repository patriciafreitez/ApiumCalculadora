package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import page.Calculadora1;
import report.ReportManager;
import resources.Configuracion;
import util.AssertUtil;

public class TestMultiplicacionDosNegativos {

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
	public void test() {
		int test = reportManager.registerTest("Multiplicacion dos negativos");
		Calculadora1.multiplicacionDosNegativos();		
		AssertUtil.assertEquals(Calculadora1.numEntero, 72, test);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
