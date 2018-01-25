package Activity;

import Logger.LoggerRun;
import UIFrame.MainFrame;

public class MainActivity {
    public static LoggerRun loggerRun = LoggerRun.getInstance();
    public static void main(String[] args){
        new MainFrame();
    }

}
