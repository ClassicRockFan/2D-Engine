package com.threesidedsquare.engine2D.administrative;


public class Logging {

    public static final int LEVEL_NULL = -1;
    public static final int LEVEL_ERROR = 0;
    public static final int LEVEL_INFO = 1;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_TRACE = 3;

    public static void printLog(String message) {
        printLog(message, LEVEL_INFO);
    }

    public static void printLog(String message, int level) {
        if (level == LEVEL_NULL)
            return;
        if (level == LEVEL_ERROR) {
            System.err.println(Time.getFormatTime() + " - [ERROR] - " + message);
            ConsoleWindow.getInstance().addConsoleText(Time.getFormatTime() + " - [ERROR] - " + message);
        } else if (level == LEVEL_INFO){
            System.out.println(Time.getFormatTime() + " - [INFO] - " + message);
            ConsoleWindow.getInstance().addConsoleText(Time.getFormatTime() + " - [INFO] - " + message);
        } else if(level==LEVEL_DEBUG){
            System.out.println(Time.getFormatTime()+" - [DEBUG] - "+message);
            ConsoleWindow.getInstance().addConsoleText(Time.getFormatTime() + " - [DEBUG] - " + message);
        } else if (level == LEVEL_TRACE){
            System.out.println(Time.getFormatTime() + " - [TRACE] - " + message);
            ConsoleWindow.getInstance().addConsoleText(Time.getFormatTime() + " - [TRACE] - " + message);
        } else {
            System.err.println("THERE WAS AN INVALID TYPE ENTERED.  PRINTING THE MESSAGE ANYWAY BELOW.");
            System.out.println(Time.getFormatTime() + " - [UNKNOWN] - " + message);
        }
    }

}
