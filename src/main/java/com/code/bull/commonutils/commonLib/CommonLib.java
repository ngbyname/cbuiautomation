package com.code.bull.commonutils.commonLib;

import com.code.bull.driver.Driver;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonLib extends Driver {

    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    /**
     * This method will print the error message
     *
     * @param message the message
     */
    public void error(String message) {
        log.error(message);
        assertCheck.append(false);
    }

    /**
     * This method will print the info message
     *
     * @param message the message
     */
    public void info(String message) {
        log.info(message);
    }

    /**
     * This method will print the warning message
     *
     * @param message the message
     */
    public void warning(String message) {
        log.warn(message);
    }


}
