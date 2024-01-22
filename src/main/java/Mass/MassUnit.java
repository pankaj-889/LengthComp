package Mass;

import Unit.Unit;

public enum MassUnit implements Unit {

    KG(1000.0),
    MG(0.001),
    G(1.0);

    private final double massPerUnit;

    MassUnit(double massPerUnit) {
        this.massPerUnit = massPerUnit;
    }

    public double getConversionFactor() {
        return massPerUnit;
    }
}
