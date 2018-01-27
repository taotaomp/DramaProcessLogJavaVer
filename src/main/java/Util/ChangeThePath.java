package Util;

public class ChangeThePath {
    public static String ConvertLinuxPath2WinPath(String linuxPath) {
        String step1 = linuxPath.replace("/media/papudding/Style", "D:");
        String step2 = step1.replaceAll("/", "\\\\");
        return step2;
    }

    public static String ConvertWinPath2LinuxPath(String winPath){
        String step1 = winPath.replace("D:","/media/papudding/Style");
        String step2 = step1.replaceAll("\\\\","/");
        return step2;
    }
}
