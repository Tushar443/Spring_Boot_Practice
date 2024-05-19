package StructuralDesignPatterns.AdaptorDesignPattern;

public class AdaptorMain {
    public static void main(){
        var pdfDocumentUploader = new PdfDocumentUploader();
        var onlineApplication = new OnlineApplication(pdfDocumentUploader);
        onlineApplication.uploadDocument();

        DocumentUploader wordDocumentUploader1 = new WordDocumentAdaptorObjectPattern();
        OnlineApplication onlineApplication1 = new OnlineApplication(wordDocumentUploader1);
        onlineApplication1.uploadDocument();

        DocumentUploader wordDocumentUploader2 = new WordDocumentAdaptorClassPattern();
        OnlineApplication onlineApplication2 = new OnlineApplication(wordDocumentUploader2);
        onlineApplication2.uploadDocument();
    }
}
