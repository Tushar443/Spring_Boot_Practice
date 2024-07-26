package BehavioralDesignPattern.MementoDP;

public class TextDocument {
    private String text = "";
    private TextDocumentState textDocumentState = new TextDocumentState(text);
    public void write(String text) {
        this.text += text;
    }

    public void print() {
        System.out.println(text);
    }

    public void save(){
        textDocumentState.setState(text);
    }

    public void undo(){
        text=textDocumentState.getState();
    }
}
