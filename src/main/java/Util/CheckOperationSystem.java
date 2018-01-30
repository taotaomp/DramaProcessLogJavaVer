package Util;

public class CheckOperationSystem {
    public static String getSystem(){
        String s = System.getProperty("os.name");
        return s;
    }
}


