package com.ubs.opsit.print;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.ubs.opsit.constants.Constants;

public class StringOutputPrinterTest
{
    private final OutputPrinter printer = new StringOutputPrinter();

    @Test
    public void verifyCorrectValueReturnedFromPrinter()
    {

        String[] inputValue = new String[24];
        Arrays.fill(inputValue, "O");
        String finalOutputValue = printer.print(inputValue);
        String expectedValue = String.join(Constants.LINE_SEPARATOR, "O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO");
        assertEquals(expectedValue, finalOutputValue);
    }

    @Test
    public void shouldReturnBlankForNullValue()
    {
        String finalOutputValue = printer.print(null);
        assertEquals("", finalOutputValue);
    }
}
