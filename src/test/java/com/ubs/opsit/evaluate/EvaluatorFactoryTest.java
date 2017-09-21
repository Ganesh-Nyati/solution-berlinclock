package com.ubs.opsit.evaluate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ubs.opsit.constants.Constants;

public class EvaluatorFactoryTest
{
    @Test (expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionWithInvalidIdentifier()
    {
        EvaluatorFactory.getEvaluator("test");
        fail("Should throw illegal argument exception.Instance identifier is invalid");
    }

    @Test
    public void VerifyHoursEvaluatorInsanceIsReturn()
    {
        Evaluator evaluator = EvaluatorFactory.getEvaluator(Constants.HOURS_EVALUATOR_TYPE);
        assertTrue(evaluator instanceof HoursEvaluator);
    }

    @Test
    public void VerifyMinutesEvaluatorInsanceIsReturn()
    {
        Evaluator evaluator = EvaluatorFactory.getEvaluator(Constants.MINUTES_EVALUATOR_TYPE);
        assertTrue(evaluator instanceof MinutesEvaluator);
    }

    @Test
    public void VerifySecondsEvaluatorInsanceIsReturn()
    {
        Evaluator evaluator = EvaluatorFactory.getEvaluator(Constants.SECONDS_EVALUATOR_TYPE);
        assertTrue(evaluator instanceof SecondsEvaluator);

    }

}
