package com.task04.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestTemperatureConverter {

    private static TemperatureConverter converter;

    @BeforeAll
    public static void init() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testConvertFtoC() {
        assertEquals(38, Math.round(converter.convertFtoC(100)));
    }

    @Test
    public void testConvertCtoF() {
        assertEquals(212, converter.convertCtoF(100));
    }

    @Test
    public void testConvertCtoK() {
        assertEquals(303.2, converter.convertCtoK(30));
    }

    @DisplayName("Should convert Kelvin to Celsius")
    @ParameterizedTest(name = "{index} => kelvin={0}, celsius={1}")
    @CsvSource({
            "0, -273.2",
            "273.2, 0"
    })
    public void testConvertKtoC(double kelvin, double celsius) {
        assertEquals(celsius, converter.convertKtoC(kelvin));
    }

    @Test
    public void testConvertFtoK() {
        assertNotEquals(10, converter.convertFtoK(100));
    }

    @Test
    public void testConvertKtoF() {
        assertNotEquals(10, converter.convertKtoF(0));
    }


}
