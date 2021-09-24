package com.example.obliq;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class RegistrationFeeTest {
    private RegistrationFee registrationFee;

    @BeforeEach
    public void setup(){
        registrationFee = new RegistrationFee();
    }

    @Test
    public void testCalRegFee(){
        int result = RegistrationFee.btn_regfee(1000,1000,1000);
        assertEquals(3000,result);
    }
}
