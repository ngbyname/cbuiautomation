package org.example;

public class ParentCB {

    /**
     * Variables
     */
    public static String result;
    public String codeBull;



    public static void main(String[] args) {
        click();
        enterText("Admin");
        click();
        enterText("admin@123");
        click();
        getUserName();
        enterText("kuch bhi print kerwa lo mere se");
        isTrue(true);
        isTrue(false);
        int results = Integer.parseInt(getResults());
        System.out.println(results);
        Integer result1 = getResult();
        String s = String.valueOf(result1);
        System.out.println(s);
    }



    /**
     * This method will return the testing results
     */
    public static void printResult() {
        System.out.println("Code Bull Testing");
    }

    /**
     * This method will be used to return the results
     *
     * @return
     */
    public static String getResults() {
        return "435";
    }

    public static Integer getResult() {
        return 435;
    }

    /**
     * This method will return the value of isChecked
     *
     * @param checkBox1 check Box 1 value
     * @param checkBox2 check Box 2 value
     * @return is Checked
     */
    public static Boolean isChecked(boolean checkBox1, boolean checkBox2) {
        boolean isChecked = checkBox1;
        System.out.println("Check Box1 value is " + checkBox1);
        System.out.println("Check Box2 value is " + checkBox2);
        return null;
    }

    public static void click() {
        try {
            System.out.println("click ker de");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void enterText(String prashant) {
        System.out.println(prashant);
    }

    public static String getUserName() {
        System.out.println("username");
        return "11";
    }

    public static void isTrue(Boolean arpit) {
        System.out.println(arpit);
    }

}