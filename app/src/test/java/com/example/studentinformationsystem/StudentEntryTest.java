package com.example.studentinformationsystem;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentEntryTest {

    @Test
    public void checkRandoms() {
        Integer random1 = 5;
        Integer random2 = 8;
        Integer theEnteredCode = 13;
        boolean output;
        StudentEntry unitTest = new StudentEntry();

        output = unitTest.checkRandoms(random1,random2,theEnteredCode, true);
        assertTrue(output);
    }

    @Test
    public void validateForm() {
    }
}