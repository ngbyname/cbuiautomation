package com.code.bull.driver;

public class Driver {
    public static String evnName = System.getProperty("Env").toUpperCase();


    public static void envLevelSetup(){
        if (evnName.equalsIgnoreCase("sit")) {

            evnName = "SIT";
        } else if (evnName.equalsIgnoreCase("uat")) {
            evnName = "UAT";
        } else {
            evnName = "PROD";
        }
    }
}
