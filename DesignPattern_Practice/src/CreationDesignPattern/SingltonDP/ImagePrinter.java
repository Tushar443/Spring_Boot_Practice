package CreationDesignPattern.SingltonDP;

public class ImagePrinter {
    public void printImage(){
        PrintSpooler ps = PrintSpooler.getInstance();
        ps.print();
    }
}
