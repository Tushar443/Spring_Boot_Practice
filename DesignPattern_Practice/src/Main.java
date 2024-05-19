import BehavioralDesignPattern.CommandDP.CommandMain;
import BehavioralDesignPattern.IteratorDP.MainClass;
import BehavioralDesignPattern.MementoDP.DocumentViewer;
import CreationDesignPattern.AbstractFactoriesDP.AbstractMain;
import CreationDesignPattern.BuilderDP.BuilderMain;
import CreationDesignPattern.FactoryDP.FactoryMain;
import CreationDesignPattern.ProtoTypeDP.ProtoTypeMain;
import CreationDesignPattern.SingltonDP.SingletonMain;
import StructuralDesignPatterns.AdaptorDesignPattern.AdaptorMain;
import StructuralDesignPatterns.BridgeDesignPattern.BridgeMain;
import StructuralDesignPatterns.CompositeDesignPattern.CompositeMain;
import StructuralDesignPatterns.FlyWeightDP.FlyWeightMain;
import StructuralDesignPatterns.ProxyDP.ProxyMain;

public class Main {

    public static void main(String[] args) {
        /**
         * Creational Design Pattern
         */
//        System.out.println();
//        System.out.println("Creational Design Pattern");
//        creationDesignPattern();

        /**
         * Structural Design Pattern
         */
//        System.out.println();
//        System.out.println("Structural Design Pattern");
//        structuralDesignPattern();
        /**
         * Behavioral Design Pattern
         */
        System.out.println();
        System.out.println("Behavioral Design Pattern");
        behavioralDesignPattern();

    }

    private static void behavioralDesignPattern() {
        /**
         * Command Design Pattern
         */
        System.out.println();
        System.out.println("Command Design Pattern");
        CommandMain.main();

        /**
         * Iterator Design Pattern
         */
        System.out.println();
        System.out.println("Iterator Design Pattern");
        MainClass.main();

        /**
         * Memento Design Pattern
         */
        System.out.println();
        System.out.println("Memento Design Pattern");
        DocumentViewer.main();

        /**
         * Observer Design Pattern
         */
        System.out.println();
        System.out.println("Observer Design Pattern");

    }

    private static void structuralDesignPattern() {
        /**
         * Adaptor Design Pattern
         */
        System.out.println();
        System.out.println("Adaptor Design Pattern");
        AdaptorMain.main();
        /**
         * Bridge Design Pattern
         */
        System.out.println();
        System.out.println("Bridge Design Pattern");
        BridgeMain.main();
        /**
         * Composite Design Pattern
         */
        System.out.println();
        System.out.println("Composite Design Pattern");
        CompositeMain.main();

        /**
         * FlyWeight DP
         */
        System.out.println();
        System.out.println("FlyWeight Design Pattern");
        FlyWeightMain.main();
        /**
         * Proxy DP
         */
        System.out.println();
        System.out.println("Proxy Design Pattern");
        ProxyMain.main();
    }

    public static void creationDesignPattern(){
        /**
         * Builder Design Pattern
         */
        System.out.println();
        System.out.println("Builder Design Pattern");
        BuilderMain.main();
        /**
         * Singlton Design Pattern
         */
        System.out.println();
        System.out.println("Singlton Design Pattern");
        SingletonMain.main();
        /**
         * ProtoType Design Pattern
         */
        System.out.println();
        System.out.println("ProtoType Design Pattern");
        ProtoTypeMain.main();
        /**
         * Factory Method Design Pattern
         */
        System.out.println();
        System.out.println("Factory Design Pattern");
        FactoryMain.main();
        /**
         * Abstract Factories Design Pattern
         */
        System.out.println();
        System.out.println("Abstract Design Pattern");
        AbstractMain.main();
    }


}