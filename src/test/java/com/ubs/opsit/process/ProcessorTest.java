package com.ubs.opsit.process;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import com.ubs.opsit.evaluate.HoursEvaluator;
import com.ubs.opsit.evaluate.MinutesEvaluator;
import com.ubs.opsit.evaluate.SecondsEvaluator;

public class ProcessorTest
{
    private static Processor processor;

    @BeforeClass
    public static void beforeTest()
    {
        processor = new ProcessorImpl();
    }

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionInvalidTimeValue()
    {
        processor.processTime(null);
        fail("Should throw illegal argument exception.Time value is null.");
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionInvalidNumberOfValues()
    {
        processor.processTime("23:59");
        fail("Should throw illegal argument exception.Time value is invalid.");
    }

    @Test
    public void verifyAllEvaluatorsInvocation()
    {
        HoursEvaluator hoursEvaluator = mock(HoursEvaluator.class);
        MinutesEvaluator minutesEvaluator = mock(MinutesEvaluator.class);
        SecondsEvaluator secondsEvaluator = mock(SecondsEvaluator.class);
        Whitebox.setInternalState(processor, "hoursEvaluator", hoursEvaluator);
        Whitebox.setInternalState(processor, "minutesEvaluator", minutesEvaluator);
        Whitebox.setInternalState(processor, "secondsEvaluator", secondsEvaluator);
        processor.processTime("23:58:45");
        verify(hoursEvaluator, times(1)).evaluate(anyInt(), anyObject());
        verify(minutesEvaluator, times(1)).evaluate(anyInt(), anyObject());
        verify(secondsEvaluator, times(1)).evaluate(anyInt(), anyObject());

    }
}
