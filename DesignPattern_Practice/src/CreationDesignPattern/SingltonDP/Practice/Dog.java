package CreationDesignPattern.SingltonDP.Practice;

public class Dog {
    private final Logger logger = Logger.getInstance();

    public void woof() {
        logger.log("Woof");
    }

}
