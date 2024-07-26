package CreationDesignPattern.SingltonDP.Practice;

public enum Logger {

    LOG_MESSAGE;

    public static Logger getInstance(){
        return LOG_MESSAGE;
    }
    void log(String logMessage) {
        System.out.println(logMessage);
    }
}
