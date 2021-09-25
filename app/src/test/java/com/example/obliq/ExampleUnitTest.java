package com.example.obliq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public ManageMarksActivity manageMarksActivity;
    //private testActivity testActivity;

    @BeforeEach
    public void setup(){

        manageMarksActivity = new ManageMarksActivity();
        //testActivity = new testActivity();
    }



    @Test
    public void testCalcStudentAverage() {
        assertEquals(3.0, manageMarksActivity.calcStudentAverage(2,3,4));
    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


}