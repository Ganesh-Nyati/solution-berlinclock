package com.ubs.opsit.evaluate;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ubs.opsit.constants.Constants;

public class SecondsEvaluatorTest
{

    private static Evaluator evaluator;

    private static final String OFF_SIGNAL = Constants.OFF_SIGNAL;
    private static final String YELLOW_SIGNAL = Constants.YELLOW_SIGNAL;

    @BeforeClass
    public static void beforeTest()
    {
        evaluator = new SecondsEvaluator();
    }

    @Test
    public void verifyWhenSecondsAreMultipleOfValueTwo()
    {
        int seconds = 12;
        String[] valueArray = new String[]
        { OFF_SIGNAL };
        evaluator.evaluate(seconds, valueArray);
        assertEquals(YELLOW_SIGNAL, valueArray[Constants.START_INDEX_OF_SECONDS_LAMP]);
    }

    @Test
    public void verifyWhenSecondsAreOdd()
    {
        int seconds = 15;
        String[] valueArray = new String[]
        { OFF_SIGNAL };
        evaluator.evaluate(seconds, valueArray);
        assertEquals(OFF_SIGNAL, valueArray[Constants.START_INDEX_OF_SECONDS_LAMP]);
    }

    @Test
    public void verifyWhenSecondsValueIsNegative()
    {
        int seconds = -14;
        String[] valueArray = new String[]
        { OFF_SIGNAL };
        evaluator.evaluate(seconds, valueArray);
        assertEquals(OFF_SIGNAL, valueArray[Constants.START_INDEX_OF_SECONDS_LAMP]);
    }

    @Test
    public void verifyWhenSecondsValueIsZero()
    {
        int seconds = 0;
        String[] valueArray = new String[]
        { OFF_SIGNAL };
        evaluator.evaluate(seconds, valueArray);
        assertEquals(YELLOW_SIGNAL, valueArray[Constants.START_INDEX_OF_SECONDS_LAMP]);
    }

}
