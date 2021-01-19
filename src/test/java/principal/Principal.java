package principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.TestCeroElevadoCero;
import test.TestMultiplicacionDosNegativos;
import test.TestNumeroEntreCero;
import test.TestRaizNegativa;
import test.TestSumaDosEnteros;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCeroElevadoCero.class,
        TestMultiplicacionDosNegativos.class,
        TestNumeroEntreCero.class,
        TestRaizNegativa.class,
        TestSumaDosEnteros.class
})
public class Principal {

}
