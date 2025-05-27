package cultivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelasTest {

	PorcionCompuesta porcionInterna;
	Soja soja;
	Trigo trigo;
	
	@BeforeEach
    public void setup() {
        // Crear la porción interna con [Soja, Soja, Trigo, Trigo]
		porcionInterna = new PorcionCompuesta();
		soja = new Soja(); // 500
		trigo = new Trigo(); // 300
        porcionInterna.addCultivo(soja);  // $250
        porcionInterna.addCultivo(soja);  // $250
        porcionInterna.addCultivo(trigo); // $75
        //porcionInterna.addCultivo(trigo); // $75
        // 125 + 125 + 75 + 75 = $400

    }
	
	@Test
	public void testPorcionCompuestaTotalSojaTrigoYTotal() {
		assertEquals(500 , soja.getGananciaAnual() , "Ganancia anual de soja incorrecta");
		assertEquals(300 , trigo.getGananciaAnual() , "Ganancia anual de trigo incorrecta");
		assertEquals(325d , porcionInterna.getGananciaAnual() , "Ganancia anual incorrecta");
	}
	


}
