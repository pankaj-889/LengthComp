package Unit;

import java.util.Objects;

public class Converter<T extends Unit> implements Comparable<Converter<T>> {

    private final Double value;
    private final T unit;

    public Converter(Double value, T unit) {
        this.value = value;
        this.unit = unit;
    }

    public Converter<T> convertToTargetUnit(T finalUnit) {
        double convertedValue = this.value * this.unit.getConversionFactor();
        convertedValue = convertedValue / finalUnit.getConversionFactor();
        return new Converter<T>(convertedValue, finalUnit);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Converter)) {
            return false;
        }

        Converter<T> otherConverterInSameUnit = (Converter<T>) o;
        otherConverterInSameUnit = otherConverterInSameUnit.convertToTargetUnit(this.unit);

        return Objects.equals(this.value, otherConverterInSameUnit.value) && this.unit == otherConverterInSameUnit.unit;
    }

    @Override
    public int hashCode() {
        String weight = value + unit.toString();
        return weight.hashCode();
    }

    @Override
    public int compareTo(Converter<T> o) {
        Converter<T> otherConverterInSameUnit = convertToTargetUnit(o.unit);

        if (this.value > otherConverterInSameUnit.value) {
            return 1;
        }
        if (this.value < otherConverterInSameUnit.value) {
            return -1;
        }
        return 0;
    }
    public Converter<T> add(Converter<T> anotherMeasurement) {
        Converter<T> convertedMeasurement = convertToTargetUnit(anotherMeasurement.unit);
        return new Converter<T>(convertedMeasurement.value + anotherMeasurement.value, anotherMeasurement.unit);
    }

    public Converter<T> subtract(Converter<T> anotherMeasurement) {
        Converter<T> convertedMeasurement = convertToTargetUnit(anotherMeasurement.unit);

        double resultValue = Math.abs(convertedMeasurement.value - anotherMeasurement.value);
        return new Converter<T>(resultValue, anotherMeasurement.unit);
    }
}
