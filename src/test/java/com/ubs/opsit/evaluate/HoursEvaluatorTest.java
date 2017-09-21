package com.ubs.opsit.evaluate;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ubs.opsit.constants.Constants;

public class HoursEvaluatorTest
{

    private static Evaluator evaluator;
    private static final String OFF_SIGNAL = Constants.OFF_SIGNAL;
    private static final String RED_SIGNAL = Constants.RED_SIGNAL;

    @BeforeClass
    public static void beforeTest()
    {
        evaluator = new HoursEvaluator();
    }

    @Test
    public void verifyHoursEvaluationCorrectValue()
    {
        int hours = 23;
        String[] valueArray = new String[9];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        assertEquals(RED_SIGNAL, valueArray[1]);
        assertEquals(RED_SIGNAL, valueArray[2]);
        assertEquals(RED_SIGNAL, valueArray[3]);
        assertEquals(RED_SIGNAL, valueArray[4]);
        assertEquals(RED_SIGNAL, valueArray[5]);
        assertEquals(RED_SIGNAL, valueArray[6]);
        assertEquals(RED_SIGNAL, valueArray[7]);
        assertEquals(OFF_SIGNAL, valueArray[8]);
    }

    @Test
    public void verifyHoursEvaluationWithZeroValue()
    {
        int hours = 0;
        String[] valueArray = new String[9];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        assertEquals(OFF_SIGNAL, valueArray[1]);
        assertEquals(OFF_SIGNAL, valueArray[2]);
        assertEquals(OFF_SIGNAL, valueArray[3]);
        assertEquals(OFF_SIGNAL, valueArray[4]);
        assertEquals(OFF_SIGNAL, valueArray[5]);
        assertEquals(OFF_SIGNAL, valueArray[6]);
        assertEquals(OFF_SIGNAL, valueArray[7]);
        assertEquals(OFF_SIGNAL, valueArray[8]);
    }

    @Test
    public void verifyHoursEvaluationWith24Value()
    {
        int hours = 24;
        String[] valueArray = new String[9];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        assertEquals(RED_SIGNAL, valueArray[1]);
        assertEquals(RED_SIGNAL, valueArray[2]);
        assertEquals(RED_SIGNAL, valueArray[3]);
        assertEquals(RED_SIGNAL, valueArray[4]);
        assertEquals(RED_SIGNAL, valueArray[5]);
        assertEquals(RED_SIGNAL, valueArray[6]);
        assertEquals(RED_SIGNAL, valueArray[7]);
        assertEquals(RED_SIGNAL, valueArray[8]);
    }

    @Test
    public void verifyHoursEvaluationWithNegativeValue()
    {
        int hours = -24;
        String[] valueArray = new String[9];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        assertEquals(OFF_SIGNAL, valueArray[1]);
        assertEquals(OFF_SIGNAL, valueArray[2]);
        assertEquals(OFF_SIGNAL, valueArray[3]);
        assertEquals(OFF_SIGNAL, valueArray[4]);
        assertEquals(OFF_SIGNAL, valueArray[5]);
        assertEquals(OFF_SIGNAL, valueArray[6]);
        assertEquals(OFF_SIGNAL, valueArray[7]);
        assertEquals(OFF_SIGNAL, valueArray[8]);
    }
}
