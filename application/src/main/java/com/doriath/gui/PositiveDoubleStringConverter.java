package com.doriath.gui;

import javafx.util.converter.DoubleStringConverter;

public class PositiveDoubleStringConverter extends DoubleStringConverter {

    @Override
    public Double fromString(String value) {
        if (value.isEmpty()){
            return 0.0;
        }
        double result = super.fromString(value);
        if (result < 0) {
            throw new RuntimeException("Negative number");
        }
        return result;
    }

    @Override
    public String toString(Double value) {
        if (value < 0) {
            return "0";
        }
        return String.format("%.2f", value);
    }

}
