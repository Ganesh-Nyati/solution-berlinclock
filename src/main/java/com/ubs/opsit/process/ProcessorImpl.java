package com.ubs.opsit.process;

import java.util.Arrays;

import com.ubs.opsit.constants.Constants;
import com.ubs.opsit.evaluate.Evaluator;
import com.ubs.opsit.evaluate.EvaluatorFactory;

public class ProcessorImpl implements Processor
{

    private final Evaluator hoursEvaluator = EvaluatorFactory.getEvaluator(Constants.HOURS_EVALUATOR_TYPE);
    private final Evaluator minutesEvaluator = EvaluatorFactory.getEvaluator(Constants.MINUTES_EVALUATOR_TYPE);
    private final Evaluator secondsEvaluator = EvaluatorFactory.getEvaluator(Constants.SECONDS_EVALUATOR_TYPE);

    @Override
    public String[] processTime(String parATime) throws IllegalArgumentException
    {
        if (parATime == null)
        {
            throw new IllegalArgumentException("Invalid input time");
        }

        String[] timeDetails = parATime.split(Constants.TIME_SPLITTER);
        if (timeDetails.length != 3)
        {
            throw new IllegalArgumentException("Invalid input time");
        }
        int hour = Integer.valueOf(timeDetails[0]);
        int minute = Integer.valueOf(timeDetails[1]);
        int second = Integer.valueOf(timeDetails[2]);

        //Initialize all lamps with OFF SIGNAL
        String[] clockSignalArray = new String[Constants.TOTAL_LAMP_COUNT];
        Arrays.fill(clockSignalArray, Constants.OFF_SIGNAL);

        //performing time evaluation
        hoursEvaluator.evaluate(hour, clockSignalArray);
        minutesEvaluator.evaluate(minute, clockSignalArray);
        secondsEvaluator.evaluate(second, clockSignalArray);

        return clockSignalArray;
    }
}
