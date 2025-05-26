package cultivos;

public class PorcionCompuesta extends PorcionDeTierra{
	
	
	@Override
	public double getGananciaAnualTotal() {
		return (super.getGananciaAnualTotal() / 4);
	}
	
	public double getGananciaAnualSoja() {
		return (super.getGananciaAnualSoja() / 4);
	}
	
	public double getGananciaAnualTrigo() {
		return (super.getGananciaAnualTrigo() / 4);
	}
	
}
