package cultivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelasTest {

	PorcionDeTierra porcionInterna;
	PorcionDeTierra porcionPrincipal;
	
	@BeforeEach
    public void setup() {
        // Crear la porción interna con [Soja, Soja, Trigo, Trigo]
		porcionInterna = new PorcionCompuesta();
        porcionInterna.addCultivo(new Soja());  // $125
        porcionInterna.addCultivo(new Soja());  // $125
        porcionInterna.addCultivo(new Trigo()); // $75
        porcionInterna.addCultivo(new Trigo()); // $75
        // 125 + 125 + 75 + 75 = $400

        porcionPrincipal = new PorcionDeTierra();
        porcionPrincipal.addCultivo(porcionInterna); // $400
        porcionPrincipal.addCultivo(new Soja());    // $500
        porcionPrincipal.addCultivo(new Trigo());   // $300
        porcionPrincipal.addCultivo(new Trigo());   // $300
        // 400 + 500 + 300 + 300 = $1500
    }
	
	@Test
	public void testPorcionCompuestaTotalSojaTrigoYTotal() {
		assertEquals(250d , porcionInterna.getGananciaAnualSoja() , "Ganancia anual de soja incorrecta");
		assertEquals(150d , porcionInterna.getGananciaAnualTrigo() , "Ganancia anual de trigo incorrecta");
		assertEquals(400d , porcionInterna.getGananciaAnualTotal() , "Ganancia anual de soja incorrecta");
	}
	
	@Test
	public void testPorcionTotalTotalSojaTrigoYTotal() {
		assertEquals(750d , porcionPrincipal.getGananciaAnualSoja() , "Ganancia anual de soja incorrecta");
		assertEquals(750d , porcionPrincipal.getGananciaAnualTrigo() , "Ganancia anual de trigo incorrecta");
		assertEquals(1500d , porcionPrincipal.getGananciaAnualTotal() , "Ganancia anual de total incorrecta");
	}

}
