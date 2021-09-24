package com.example.obliq;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class CalculationsTest {

    private Calculations calculations;

    @BeforeEach
    public void setup(){
        calculations = new Calculations();
    }

    @Test
    public void testCalRegFee(){
        assertEquals(1000,Calculations.calcRegFee(2));
    }

}
