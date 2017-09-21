package com.ubs.opsit.evaluate;

import com.ubs.opsit.constants.Constants;

public class HoursEvaluator implements Evaluator
{

    private static final int VALUE_OF_HOURS_LAMP_FOR_FIRST_ROW = Constants.VALUE_OF_HOURS_LAMP_FOR_FIRST_ROW;

    @Override
    public void evaluate(int hours, String[] convertedTimeArray)
    {
        if (hours > 0)
        {
            //calculate hours value for first row
            int countOfONLampsForFirstRow = getCountOfONLampsInFirstRow(hours, VALUE_OF_HOURS_LAMP_FOR_FIRST_ROW);
            getConvertedHoursValue(convertedTimeArray, Constants.START_INDEX_OF_HOURS_LAMP_FOR_FIRST, countOfONLampsForFirstRow);

            //calculate hours value for second row
            int countOfONLampsForSecondRow = getCountOfONLampsInSecondRow(hours, VALUE_OF_HOURS_LAMP_FOR_FIRST_ROW);
            getConvertedHoursValue(convertedTimeArray, Constants.START_INDEX_OF_HOURS_LAMP_FOR_SECOND, countOfONLampsForSecondRow);
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

    private void getConvertedHoursValue(String[] convertedTimeArray, int startIndex, int onLampsCount)
    {
        for (int i = startIndex; i < (startIndex + onLampsCount); i++)
        {
            convertedTimeArray[i] = Constants.RED_SIGNAL;
        }
    }
}
