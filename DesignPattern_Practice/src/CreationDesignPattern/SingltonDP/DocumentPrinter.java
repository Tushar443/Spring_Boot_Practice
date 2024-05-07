package CreationDesignPattern.SingltonDP;

public class DocumentPrinter {
    public void DocumentImage(){
        PrintSpooler ps = PrintSpooler.getInstance();
        ps.print();
    }
}
