package com.ubs.opsit.evaluate;

import com.ubs.opsit.constants.Constants;

public class SecondsEvaluator implements Evaluator
{

    @Override
    public void evaluate(int seconds, String[] convertedTimeArray)
    {
        if (seconds >= 0 && seconds % Constants.VALUE_OF_SECONDS_LAMP == 0)
        {
            convertedTimeArray[Constants.START_INDEX_OF_SECONDS_LAMP] = Constants.YELLOW_SIGNAL;
        }
    }
}
