package cultivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelasTest {

	PorcionCompuesta porcionInterna;
	PorcionCompuesta porcionInterna2;
	Soja soja;
	Trigo trigo;
	
	@BeforeEach
    public void setup() {
        // Crear la porción interna con [Soja, Soja, Trigo, Trigo]
		porcionInterna = new PorcionCompuesta();
		porcionInterna2 = new PorcionCompuesta();
		soja = new Soja(); // 500
		trigo = new Trigo(); // 300
		porcionInterna2.addCultivo(soja); // $125
		porcionInterna2.addCultivo(soja); // $125
		porcionInterna2.addCultivo(trigo); // $75
		porcionInterna2.addCultivo(trigo); // $75
		//Porcion interna2 400 en total
        porcionInterna.addCultivo(soja);  // $125
        porcionInterna.addCultivo(soja);  // $125
        porcionInterna.addCultivo(trigo); // $75
        porcionInterna.addCultivo(porcionInterna2); // $50

    }
	
	@Test
	public void testPorcionCompuestaTotalSojaTrigoYTotal() {
		assertEquals(500d , soja.getGananciaAnual() , "Ganancia anual de soja incorrecta");
		assertEquals(300d , trigo.getGananciaAnual() , "Ganancia anual de trigo incorrecta");
		assertEquals(400d , porcionInterna2.getGananciaAnual() , "Ganancia anual incorrecta");
		assertEquals(425d , porcionInterna.getGananciaAnual() , "Ganancia anual incorrecta");
	}
	
	@Test
	public void testNoSePuedeAgregarMasDe4Subporciones() {

	    Exception excepcion = assertThrows(IllegalStateException.class, () -> {
	    	porcionInterna.addCultivo(new Soja());
	    });

	    assertEquals("Máximo 4 sub-porciones.", excepcion.getMessage());
	}
	


}
