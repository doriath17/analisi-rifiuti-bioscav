package com.doriath.guicomponents.util.stringconverter;

import javafx.util.StringConverter;

public class PositiveIntegerStringConverter extends StringConverter<Integer> {

    public static final PositiveIntegerStringConverter instance = new PositiveIntegerStringConverter();

    @Override
    public String toString(Integer value) {
        return value.toString();
    }

    @Override
    public Integer fromString(String string) {
        return Integer.valueOf(string);
    }
}
