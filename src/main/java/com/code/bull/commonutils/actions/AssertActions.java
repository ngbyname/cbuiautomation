package com.code.bull.commonutils.actions;


import org.testng.Assert;

public class AssertActions {

    public static Boolean assertFlag = null;

    public Boolean assertEqualsBoolean(boolean actual, boolean expected) {
        return assertEqualsBoolean(actual, expected, "", "");
    }

    public Boolean assertEqualsBoolean(boolean actual, boolean expected, String passDesc, String failDesc) {
        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected);
            assertFlag = true;
            System.out.println(passDesc);
        } catch (Exception ex) {
            //TODO add logging here
            System.out.println(failDesc + ex.getMessage());
        }
        return assertFlag;
    }

    public String assertEqualsString(String actual, String expected) {
        return String.valueOf(assertEqualsString(actual,expected,"",""));
    }

    public Boolean assertEqualsString(String actual, String expected, String passDesc, String failDesc) {
        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected);
            assertFlag = true;
            System.out.println(passDesc);
        } catch (Exception ex) {
            //TODO add logging here
            System.out.println(failDesc + ex.getMessage());
        }
        return assertFlag;
    }
}
