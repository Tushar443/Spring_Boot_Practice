package BehavioralDesignPattern.MementoDP;

public class DocumentViewer {

    public static void main(){
        var textDocument = new TextDocument();
        textDocument.write("Hello, world! ");
        textDocument.save();
        textDocument.print();
        textDocument.write("How are you?");
        textDocument.print();
        textDocument.undo();
        textDocument.print();
    }
}
