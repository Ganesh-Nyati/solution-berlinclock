package com.ubs.opsit.evaluate;

import com.ubs.opsit.constants.Constants;

public class MinutesEvaluator implements Evaluator
{

    private static final int VALUE_OF_MINUTES_LAMP_FOR_FIRST_ROW = Constants.VALUE_OF_MINUTES_LAMP_FOR_FIRST_ROW;
    private static final String RED_SIGNAL = Constants.RED_SIGNAL;
    private static final int LAST_QUARTER_OF_HOURS_LAMP_POSITION = Constants.LAST_QUARTER_OF_HOURS_LAMP_POSITION;
    private static final int HALF_QUARTER_OF_HOURS_LAMP_POSITION = Constants.HALF_QUARTER_OF_HOURS_LAMP_POSITION;
    private static final int FIRST_QUARTER_OF_HOURS_LAMP_POSITION = Constants.FIRST_QUARTER_OF_HOURS_LAMP_POSITION;

    //

    @Override
    public void evaluate(int minutes, String[] convertedTimeArray)
    {
        if (minutes > 0)
        {
            //calculate minutes value for first row
            int countOfONLampsForFirstRow = getCountOfONLampsInFirstRow(minutes, VALUE_OF_MINUTES_LAMP_FOR_FIRST_ROW);
            getConvertedMinutesValue(convertedTimeArray, Constants.START_INDEX_OF_MINUTES_LAMP_FOR_FIRST, countOfONLampsForFirstRow);

            //calculate minutes value for special condition when time value is 15||30||45 minutes
            getSpecialConvertedMinutesValue(convertedTimeArray, Constants.START_INDEX_OF_MINUTES_LAMP_FOR_FIRST, countOfONLampsForFirstRow);

            //calculate minutes value for second row
            int countOfONLampsForSecondRow = getCountOfONLampsInSecondRow(minutes, VALUE_OF_MINUTES_LAMP_FOR_FIRST_ROW);
            getConvertedMinutesValue(convertedTimeArray, Constants.START_INDEX_OF_MINUTES_LAMP_FOR_SECOND, countOfONLampsForSecondRow);
        }
    }

    private int getCountOfONLampsInFirstRow(int time, int valueForLamp)
    {

        return time / valueForLamp;
    }

    private int getCountOfONLampsInSecondRow(int time, int valueForLamp)
    {

        return time % valueForLamp;
    }

    private void getConvertedMinutesValue(String[] convertedTimeArray, int startIndex, int onLampsCount)
    {
        for (int i = startIndex; i < (startIndex + onLampsCount); i++)
        {
            convertedTimeArray[i] = Constants.YELLOW_SIGNAL;
        }
    }

    private void getSpecialConvertedMinutesValue(String[] parConvertedTimeArray, int startIndex, int parCountOfONLampsForFirstRow)
    {
        if (parCountOfONLampsForFirstRow >= FIRST_QUARTER_OF_HOURS_LAMP_POSITION)
        {
            parConvertedTimeArray[startIndex + FIRST_QUARTER_OF_HOURS_LAMP_POSITION - 1] = RED_SIGNAL;
            if (parCountOfONLampsForFirstRow >= HALF_QUARTER_OF_HOURS_LAMP_POSITION)
            {
                parConvertedTimeArray[startIndex + HALF_QUARTER_OF_HOURS_LAMP_POSITION - 1] = RED_SIGNAL;
                if (parCountOfONLampsForFirstRow >= LAST_QUARTER_OF_HOURS_LAMP_POSITION)
                {
                    parConvertedTimeArray[startIndex + LAST_QUARTER_OF_HOURS_LAMP_POSITION - 1] = RED_SIGNAL;
                }
            }
        }
    }
}
