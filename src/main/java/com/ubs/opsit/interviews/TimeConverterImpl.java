package com.ubs.opsit.interviews;

import com.ubs.opsit.print.OutputPrinter;
import com.ubs.opsit.print.StringOutputPrinter;
import com.ubs.opsit.process.Processor;
import com.ubs.opsit.process.ProcessorImpl;
import com.ubs.opsit.validate.Validator;
import com.ubs.opsit.validate.ValidatorImpl;

public class TimeConverterImpl implements TimeConverter
{
    private final Validator validator = new ValidatorImpl();
    private final Processor timeProcessor = new ProcessorImpl();
    private final OutputPrinter printer = new StringOutputPrinter();

    @Override
    public String convertTime(String aTime)
    {
        if (validator.isValidTime(aTime))
        {
            String[] convertedTime = timeProcessor.processTime(aTime);
            return printer.print(convertedTime);
        }
        else
        {
            System.err.println("Invalid input time");
            throw new IllegalArgumentException("Invalid input time");
        }
    }
}
