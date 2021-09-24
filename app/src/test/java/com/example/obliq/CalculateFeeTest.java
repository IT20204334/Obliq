package com.example.obliq;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

public class CalculateFeeTest {

    private Calculatefee calculatefee;

    @BeforeEach
    public void setup(){
        calculatefee = new Calculatefee();
    }

    @Test
    public  void testcalClassFee(){
        int result = Calculatefee.calClassFee(5,500);
        assertEquals(2500,result);
    }




}
