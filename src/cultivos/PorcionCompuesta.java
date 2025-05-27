package cultivos;

import java.util.ArrayList;
import java.util.List;

public class PorcionCompuesta extends PorcionDeTierra {
    private List<PorcionDeTierra> subPorciones;

    public PorcionCompuesta() {
        this.subPorciones = new ArrayList<>();
    }

    public void addCultivo(PorcionDeTierra p) {
        if (subPorciones.size() < 4) {
            subPorciones.add(p);
        } else {
            throw new IllegalStateException("Máximo 4 sub-porciones.");
        }
    }

    @Override
    public double getGananciaAnual() {
        double total = 0.0;
        
        for (PorcionDeTierra sub : subPorciones) {
            total += sub.getGananciaAnual();
        }
        
        return total / 4.0;
    }
    

    public List<PorcionDeTierra> getSubPorciones() {
        return subPorciones;
    }
}
