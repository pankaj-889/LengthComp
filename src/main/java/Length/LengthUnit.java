package Length;

import Unit.Unit;

public enum LengthUnit implements Unit{

    KM(1000.0),
    CM(0.01),
    M(1.0),
    MM(0.001);


    private final double metersPerUnit;

    LengthUnit(double metersPerUnit) {
        this.metersPerUnit = metersPerUnit;
    }
    public double getConversionFactor() {
        return metersPerUnit;
    }
}
