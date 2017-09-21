package com.ubs.opsit.evaluate;

import com.ubs.opsit.constants.Constants;

public class EvaluatorFactory
{

    public static Evaluator getEvaluator(String evaluatorType) throws IllegalArgumentException
    {
        if (Constants.HOURS_EVALUATOR_TYPE.equalsIgnoreCase(evaluatorType))
        {
            return new HoursEvaluator();
        }
        else if (Constants.MINUTES_EVALUATOR_TYPE.equalsIgnoreCase(evaluatorType))
        {
            return new MinutesEvaluator();
        }

        else if (Constants.SECONDS_EVALUATOR_TYPE.equalsIgnoreCase(evaluatorType))
        {
            return new SecondsEvaluator();
        }
        else
        {
            throw new IllegalArgumentException("Illegal Evaluator type");

        }
    }
}
