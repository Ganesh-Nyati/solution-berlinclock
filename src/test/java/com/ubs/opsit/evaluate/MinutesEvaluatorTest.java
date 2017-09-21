package com.ubs.opsit.evaluate;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ubs.opsit.constants.Constants;

public class MinutesEvaluatorTest
{

    private static Evaluator evaluator;

    private static final int START_INDEX_FOR_FIRST = Constants.START_INDEX_OF_MINUTES_LAMP_FOR_FIRST;
    private static final int START_INDEX_FOR_SECOND = Constants.START_INDEX_OF_MINUTES_LAMP_FOR_SECOND;
    private static final String OFF_SIGNAL = Constants.OFF_SIGNAL;
    private static final String YELLOW_SIGNAL = Constants.YELLOW_SIGNAL;
    private static final String RED_SIGNAL = Constants.RED_SIGNAL;

    @BeforeClass
    public static void beforeTest()
    {
        evaluator = new MinutesEvaluator();
    }

    @Test
    public void verifyMinutesEvaluationWithCorrectValue()
    {
        int minutes = 11;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(minutes, valueArray);
        assertEquals(YELLOW_SIGNAL, valueArray[START_INDEX_FOR_FIRST]);
        assertEquals(YELLOW_SIGNAL, valueArray[START_INDEX_FOR_FIRST + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        assertEquals(YELLOW_SIGNAL, valueArray[START_INDEX_FOR_SECOND]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    @Test
    public void verifyHoursEvaluationWithZeroValue()
    {
        int minutes = 0;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(minutes, valueArray);
        //
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        //
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    @Test
    public void verifyMinutesEvaluationWith59Value()
    {
        int hours = 59;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        //
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 1]);
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        //
        assertYellowSignal(valueArray[START_INDEX_FOR_SECOND]);
        assertYellowSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertYellowSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertYellowSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    @Test
    public void verifyWhenMinutesValueIsFirstQuarterOfHours()
    {
        int hours = 15;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);

        //first row of minutes lamp
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 1]);
        // special case for FirstQuarter minutes
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        //second row of minutes lamp
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    @Test
    public void verifyWhenMinutesValueIsSecondQuarterOfHours()
    {
        int hours = 30;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        //first row of minutes lamp
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 1]);
        // special case for SecondQuarter minutes
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        // special case for SecondQuarter minutes
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        //second row of minutes lamp
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    @Test
    public void verifyWhenMinutesValueIsLastQuarterOfHours()
    {
        int hours = 45;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        //first row of minutes lamp
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 1]);
        //special case for LastQuarter minutes
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        //special case for LastQuarter minutes
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertYellowSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        //special case for LastQuarter minutes
        assertREDSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        //second row of minutes lamp
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    @Test
    public void verifyHoursEvaluationWithNegativeValue()
    {
        int hours = -59;
        String[] valueArray = new String[24];
        Arrays.fill(valueArray, OFF_SIGNAL);
        evaluator.evaluate(hours, valueArray);
        //first row of minutes lamp
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 3]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 4]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 5]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 6]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 7]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 8]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 9]);
        assertOFFSignal(valueArray[START_INDEX_FOR_FIRST + 10]);
        //second row of minutes lamp
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 1]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 2]);
        assertOFFSignal(valueArray[START_INDEX_FOR_SECOND + 3]);
    }

    private void assertYellowSignal(String yellowSignal)
    {
        assertEquals(YELLOW_SIGNAL, yellowSignal);
    }

    private void assertOFFSignal(String offSignal)
    {
        assertEquals(OFF_SIGNAL, offSignal);

    }

    private void assertREDSignal(String redSignal)
    {
        assertEquals(RED_SIGNAL, redSignal);

    }

}
