package com.ubs.opsit.validate;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ValidatorTest
{
    private static Validator validator;

    @BeforeClass
    public static void beforeTest()
    {
        validator = new ValidatorImpl();

    }

    @Test
    public void shouldReturnFalseHoursIsOutOfRange()
    {
        String time = "25:00:00";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseMinutesIsOutOfRange()
    {
        String time = "23:99:00";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseSecondsIsOutOfRange()
    {
        String time = "23:59:99";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseHoursHasInvalidCharacters()
    {
        String time = "2b:59:99";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseMinutesHasInvalidCharacters()
    {
        String time = "23:ab:99";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseSecondsHasInvalidCharacters()
    {
        String time = "23:59:hz";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseHoursHasThreeDigitValue()
    {
        String time = "230:59:59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseMinutesHasThreeDigitValue()
    {
        String time = "23:590:59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseSecondsHasThreeDigitValue()
    {
        String time = "23:59:590";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseHoursIsNegativeValue()
    {
        String time = "-23:59:59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseMinutesIsNegative()
    {
        String time = "23:-59:59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseSecondsIsNegative()
    {
        String time = "23:59:-59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseHoursHasOneDigit()
    {
        String time = "3:59:59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseMinutesHasOneDigit()
    {
        String time = "23:9:59";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseSecondsHasOneDigit()
    {
        String time = "23:59:9";
        assertEquals(false, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnTrueAllValuesAreZero()
    {
        String time = "00:00:00";
        assertEquals(true, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnTrueWithValidTime()
    {
        String time = "12:14:23";
        assertEquals(true, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnTrueWhenTimeIsMidnight()
    {
        String time = "24:00:00";
        assertEquals(true, validator.isValidTime(time));
    }

    @Test
    public void shouldReturnFalseWhenTimeIsOutOfRange()
    {
        String time = "24:01:00";
        assertEquals(false, validator.isValidTime(time));
    }
}
