package com.ubs.opsit.validate;

import java.util.regex.Pattern;

public class ValidatorImpl implements Validator
{
    private static final Pattern VALID_TIME_PATTERN = Pattern.compile("([0-2][0-3])(:[0-5][0-9]){2}|(24:00:00)");

    @Override
    public boolean isValidTime(String inputTime)
    {
        if (VALID_TIME_PATTERN.matcher(inputTime).matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
