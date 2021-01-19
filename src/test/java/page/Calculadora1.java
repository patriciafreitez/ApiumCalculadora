package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import principal.Base;

public class Calculadora1 extends Base{
	public int numEntero;
	
	
//	@AndroidFindBy(xpath = "(//android.widget.Button[contains(@resource-id,'digit_0')]")
//	WebElement cero;
	
	By cero = By.xpath("//android.widget.Button[contains(@resource-id,'digit_0')]");
	By uno = By.xpath("//android.widget.Button[contains(@resource-id,'digit_1')]");
	By dos = By.xpath("//android.widget.Button[contains(@resource-id,'digit_2')]");
	By tres = By.xpath("//android.widget.Button[contains(@resource-id,'digit_3')]");
	By cinco = By.xpath("//android.widget.Button[contains(@resource-id,'pad_btn_c_b')]");
	By ocho = By.xpath("//android.widget.Button[contains(@resource-id,'digit_8')]");
	By nueve = By.xpath("//android.widget.Button[contains(@resource-id,'digit_9')]");
	By mas = By.xpath("//android.widget.Button[contains(@resource-id,'op_add')]");
	By igual = By.xpath("//android.widget.Button[contains(@resource-id,'eq')]");
	By resultado = By.xpath("//android.widget.TextView[contains(@resource-id,'result_final')]");
	By menos = By.xpath("//android.widget.Button[contains(@resource-id,'op_sub')]");
	By parentesis1 = By.xpath("//android.widget.Button[contains(@resource-id,'lparen')]");
	By parentesis2 = By.xpath("//android.widget.Button[contains(@resource-id,'rparen')]");
	By por = By.xpath("//android.widget.Button[contains(@resource-id,'op_mul')]");
	By entre = By.xpath("//android.widget.Button[contains(@resource-id,'op_div')]");
	By preResultado = By.xpath("//android.widget.TextView[contains(@resource-id,'result_preview')]");
	By potencia = By.xpath("//android.widget.Button[contains(@resource-id,'op_pow')]");
	By raizCuadrada = By.xpath("//android.widget.Button[contains(@resource-id,'op_sqrt')]");




	public Calculadora1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void sumaDosEnteros(){
		click(nueve);
		click(mas);
		click(tres);
		click(igual);
		sleep(1);
	    numEntero = Integer.parseInt(getText(resultado));
	}	
	public void multiplicacionDosNegativos() {
		click(parentesis1);
		click(menos);
		click(ocho);
		click(parentesis2);
		click(por);
		click(parentesis1);
		click(menos);
		click(nueve);
		click(parentesis2);
		click(igual);
		sleep(1);
		numEntero = Integer.parseInt(getText(resultado));
		
	}
	public String numeroEntreCero() throws Exception {
		click(dos);
		click(entre);
		click(cero);
		click(igual);
		sleep(1);
		return getText(preResultado);
	}
	public String ceroElevadoCero() throws Exception {
		click(cero);
		click(potencia);
		click(cero);
		click(igual);
		sleep(1);
		return getText(preResultado);
	}

	public String raizNegativa() throws Exception {
		click(raizCuadrada);
		click(menos);
		click(uno);
		click(igual);
		sleep(1);
		return getText(preResultado);
	}
}
