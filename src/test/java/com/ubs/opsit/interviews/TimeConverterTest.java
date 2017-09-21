package com.ubs.opsit.interviews;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import com.ubs.opsit.print.OutputPrinter;
import com.ubs.opsit.process.Processor;
import com.ubs.opsit.validate.Validator;

public class TimeConverterTest
{
    private static TimeConverter timeConverter = new TimeConverterImpl();

    @Mock
    private Validator validator;
    @Mock
    private Processor processor;
    @Mock
    private OutputPrinter outputPrinter;

    @BeforeClass
    public static void beforeTest()
    {
        timeConverter = new TimeConverterImpl();
    }

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionTimeValidationFails()
    {
        Whitebox.setInternalState(timeConverter, "validator", validator);
        when(validator.isValidTime(anyString())).thenReturn(false);
        timeConverter.convertTime("88:23:34");
        verify(validator).isValidTime("88:23:34");
        fail("Should throw illegal argument exception.Input Time is invalid");
    }

    @Test
    public void verifyProcessorInvokedWithSuccessfulValidation()
    {
        Whitebox.setInternalState(timeConverter, "validator", validator);
        when(validator.isValidTime(anyString())).thenReturn(true);
        Whitebox.setInternalState(timeConverter, "timeProcessor", processor);
        when(processor.processTime(anyString())).thenReturn(new String[24]);
        timeConverter.convertTime("23:59:59");
        verify(processor).processTime("23:59:59");
    }

    @Test
    public void verifyPrinterInvokedWithSuccessfulValidation()
    {
        Whitebox.setInternalState(timeConverter, "validator", validator);
        when(validator.isValidTime(anyString())).thenReturn(true);
        Whitebox.setInternalState(timeConverter, "timeProcessor", processor);
        when(processor.processTime(anyString())).thenReturn(new String[24]);
        Whitebox.setInternalState(timeConverter, "printer", outputPrinter);
        when(outputPrinter.print(new String[24])).thenReturn(anyString());
        timeConverter.convertTime("23:59:59");
        verify(outputPrinter).print(anyObject());
    }
}
