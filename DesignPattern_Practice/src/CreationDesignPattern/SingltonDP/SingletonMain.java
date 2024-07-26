package CreationDesignPattern.SingltonDP;

import CreationDesignPattern.SingltonDP.Practice.Cat;
import CreationDesignPattern.SingltonDP.Practice.Dog;

public class SingletonMain {
    public static void main(){
        DocumentPrinter dc = new DocumentPrinter();
        dc.DocumentImage();
        ImagePrinter im = new ImagePrinter();
        im.printImage();

        // Practice
        var dog = new Dog();
        dog.woof();

        var cat = new Cat();
        cat.meow();
    }
}
