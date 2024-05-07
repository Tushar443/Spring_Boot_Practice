package CreationDesignPattern.SingltonDP;

public enum PrintSpooler {

    printSpooler;

    PrintSpooler() {
    }

    public static PrintSpooler getInstance() {
        return printSpooler;
    }

    public void print() {
        System.out.println("Printing....");
    }
}
