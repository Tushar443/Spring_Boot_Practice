package BehavioralDesignPattern.MementoDP;

public class DocumentViewer {

    public static void main(){
        var textDocument = new TextDocument();
        textDocument.write("Hello, world! ");
        textDocument.print();
        textDocument.write("How are you?");
        textDocument.print();
    }
}
