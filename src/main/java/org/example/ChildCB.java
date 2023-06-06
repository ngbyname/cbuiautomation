package org.example;

import java.lang.reflect.Array;

import static org.example.ParentCB.enterText;

public class ChildCB {
    private String codeBull;
    Array array[];


    ParentCB p = new ParentCB();


    public void getStatus() {
        Boolean checked = p.isChecked(false, true);
        p.printResult();
        System.out.println(checked);
    }

    public void enterUsername(){
        enterText("Admin");
    }

    public void enterPass(){
        enterText("admin123");
    }

    public static void enterPasss(){
        enterText("admin123");
    }

    public static Boolean isChecked(boolean checkBox1, boolean checkBox2, boolean checkBox3) {
        boolean isChecked = checkBox1;
        System.out.println("Check Box1 value is " + checkBox1);
        System.out.println("Check Box2 value is " + checkBox2);
        return null;
    }

}