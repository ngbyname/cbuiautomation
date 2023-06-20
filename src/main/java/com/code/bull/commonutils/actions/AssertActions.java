package com.code.bull.commonutils.actions;


import com.code.bull.driver.Driver;
import org.testng.Assert;

public class AssertActions extends Driver {

    public static Boolean assertFlag = null;

    public Boolean assertEqualsBoolean(boolean actual, boolean expected) {
        return assertEqualsBoolean(actual, expected, "", "");
    }

    public Boolean assertEqualsBoolean(boolean actual, boolean expected, String passDesc, String failDesc) {
        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected);
            assertFlag = true;
            commonLib.info("Message :- " + passDesc);
        } catch (Exception ex) {
            commonLib.error(ex.getMessage() + "Message :-" + failDesc);
        }
        return assertFlag;
    }

    public Boolean assertEqualsString(String actual, String expected) {
        return assertEqualsString(actual, expected, "", "");
    }

    public Boolean assertEqualsString(String actual, String expected, String passDesc, String failDesc) {
        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected);
            assertFlag = true;
            commonLib.info("Message :- " + passDesc);
        } catch (Exception ex) {
            commonLib.error(ex.getMessage() + "Message :-" + failDesc);
        }
        return assertFlag;
    }

    public boolean assertAllFoundFailedAssert(StringBuilder assertResults) {
        // ACTION PENDING - REQUIRE TO CALL THIS TO @AFTERMETHOD
        if (assertResults.toString().equals("") || assertResults.toString().contains("false")) {
            Assert.fail("Some Assertions failed in this testcase");
            return true;
        } else
            commonLib.info("All Assertion Verified and are Passed");
        return false;
    }
}
