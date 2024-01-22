package Volume;

import Unit.Unit;

public enum VolumeUnit implements Unit {
    L(1.0),
    CM(1000.0),
    ML(0.001);

    private final double literPerUnit;

    VolumeUnit(double literPerUnit) {
        this.literPerUnit = literPerUnit;
    }
    public double getConversionFactor() {
        return literPerUnit;
    }
}
