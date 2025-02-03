package com.doriath.guicomponents.util;

import javafx.util.StringConverter;

public class PositiveIntegerConverter extends StringConverter<Integer> {

    @Override
    public String toString(Integer value) {
        return value.toString();
    }

    @Override
    public Integer fromString(String string) {
        return Integer.valueOf(string);
    }
}
