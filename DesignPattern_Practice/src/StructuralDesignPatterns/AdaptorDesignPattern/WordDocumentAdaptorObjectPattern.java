package StructuralDesignPatterns.AdaptorDesignPattern;

public class WordDocumentAdaptorObjectPattern implements DocumentUploader{

    private final WordDocumentUploader wordDocumentUploader;

    public WordDocumentAdaptorObjectPattern() {
        this.wordDocumentUploader = new WordDocumentUploader();
    }

    @Override
    public void upload() {
        wordDocumentUploader.uploadWordDocument();
    }
}
