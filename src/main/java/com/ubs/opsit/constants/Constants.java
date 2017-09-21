package com.ubs.opsit.constants;

public class Constants
{
    //Lamp signals
    public static final String RED_SIGNAL = "R";
    public static final String YELLOW_SIGNAL = "Y";
    public static final String OFF_SIGNAL = "O";

    //Start index of lamps
    public static final int START_INDEX_OF_SECONDS_LAMP = 0;
    public static final int START_INDEX_OF_HOURS_LAMP_FOR_FIRST = 1;
    public static final int START_INDEX_OF_HOURS_LAMP_FOR_SECOND = 5;
    public static final int START_INDEX_OF_MINUTES_LAMP_FOR_FIRST = 9;
    public static final int START_INDEX_OF_MINUTES_LAMP_FOR_SECOND = 20;

    //Value count of lamps
    public static final int VALUE_OF_HOURS_LAMP_FOR_FIRST_ROW = 5;
    public static final int VALUE_OF_HOURS_LAMP_FOR_SECOND_ROW = 1;
    public static final int VALUE_OF_MINUTES_LAMP_FOR_FIRST_ROW = 5;
    public static final int VALUE_OF_MINUTES_LAMP_FOR_SECOND_ROW = 1;
    public static final int VALUE_OF_SECONDS_LAMP = 2;

    // lamp position for hour first, half and last quarter
    public static final int FIRST_QUARTER_OF_HOURS_LAMP_POSITION = 3;
    public static final int HALF_QUARTER_OF_HOURS_LAMP_POSITION = 6;
    public static final int LAST_QUARTER_OF_HOURS_LAMP_POSITION = 9;

    //Evaluators type
    public static final String HOURS_EVALUATOR_TYPE = "hours_evaluator";
    public static final String MINUTES_EVALUATOR_TYPE = "minutes_evaluator";
    public static final String SECONDS_EVALUATOR_TYPE = "seconds_evaluator";

    public static final int TOTAL_LAMP_COUNT = 24;
    public static final String TIME_SPLITTER = ":";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
