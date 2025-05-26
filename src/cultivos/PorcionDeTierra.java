package cultivos;

import java.util.ArrayList;
import java.util.List;

public class PorcionDeTierra implements IParcela{
	private List<IParcela> cultivos = new ArrayList<IParcela>();
	
	public void addCultivo(IParcela p) {
		cultivos.add(p);
	}
	
	public void deleteCultivo(IParcela p) {
		cultivos.remove(p);
	}
	
	public double getGananciaAnualSoja() {
		double totalGananciaAnual = 0d; 
		
		for (IParcela parcela : cultivos) {
			totalGananciaAnual += parcela.getGananciaAnualSoja();
		}
		return totalGananciaAnual;
	}
	
	public double getGananciaAnualTrigo() {
		double totalGananciaAnual = 0d; 
		
		for (IParcela parcela : cultivos) {
			totalGananciaAnual += parcela.getGananciaAnualTrigo();
		}
		return totalGananciaAnual;
	}
	
	
	public double getGananciaAnualTotal() {
		double totalGananciaAnual = 0d; 
		
		for (IParcela parcela : cultivos) {
			totalGananciaAnual += parcela.getGananciaAnualSoja() + parcela.getGananciaAnualTrigo();
		}
		return totalGananciaAnual;
	}
 
}
