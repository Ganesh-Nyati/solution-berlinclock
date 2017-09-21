package com.ubs.opsit.print;

import com.ubs.opsit.constants.Constants;

public class StringOutputPrinter implements OutputPrinter
{

    @Override
    public String print(String[] timeValue)
    {
        if (timeValue == null)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < timeValue.length; i++)
        {
            sb.append(timeValue[i]);
            if (i == Constants.START_INDEX_OF_SECONDS_LAMP || i == Constants.START_INDEX_OF_HOURS_LAMP_FOR_SECOND - 1
                    || i == Constants.START_INDEX_OF_MINUTES_LAMP_FOR_FIRST - 1 || i == Constants.START_INDEX_OF_MINUTES_LAMP_FOR_SECOND - 1)
            {
                sb.append(Constants.LINE_SEPARATOR);
            }
        }
        return sb.toString();
    }
}
