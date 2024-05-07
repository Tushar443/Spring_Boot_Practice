import CreationDesignPattern.AbstractFactoriesDP.*;
import CreationDesignPattern.BuilderDP.Person;
import CreationDesignPattern.FactoryDP.Ticket;
import CreationDesignPattern.FactoryDP.TicketMachine;
import CreationDesignPattern.ProtoTypeDP.Meal;
import CreationDesignPattern.ProtoTypeDP.Pizza;
import CreationDesignPattern.ProtoTypeDP.PizzaFlavour;
import CreationDesignPattern.SingltonDP.DocumentPrinter;
import CreationDesignPattern.SingltonDP.ImagePrinter;
import CreationDesignPattern.SingltonDP.Practice.Cat;
import CreationDesignPattern.SingltonDP.Practice.Dog;
import CreationDesignPattern.SingltonDP.PrintSpooler;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Builder Design Pattern
         */
        //BuilderDp();
        /**
         * Singlton Design Pattern
         */
        //SingletonDp();
        /**
         * ProtoType Design Pattern
         */
//        ProtoTypeDP();
        /**
         * Factory Method Design Pattern
         */
//        FactoryMethodDP();
        /**
         * Abstract Factories Design Pattern
         */
        abstractDP();
    }

    private static void abstractDP() {
        Bike roadBike = buildBike("road");
        Bike mountainBike = buildBike("mountain");
        System.out.println("Road Bike = "+roadBike);
        System.out.println("Mountain Bike = "+mountainBike);
    }

    private static Bike buildBike(String bikeType) {
        BikeFactory bikeFactory = FactoryMaker.createFactory(bikeType);
        HandleBars handleBars = bikeFactory.createHandlerBar();
        Pedals pedals = bikeFactory.createPedals();
        Tire front = bikeFactory.createTire();
        Tire back = bikeFactory.createTire();
        return new Bike(handleBars,pedals,front,back);
//        if (bikeType.equalsIgnoreCase("ROAD")) {
//            RoadBikeFactory roadBikeFactory = new RoadBikeFactory();
//            HandleBars handleBars = roadBikeFactory.createHandlerBar();
//            Pedals pedals = roadBikeFactory.createPedals();
//            Tire front = roadBikeFactory.createTire();
//            Tire back = roadBikeFactory.createTire();
//            return new Bike(handleBars,pedals,front,back);
//        } else if (bikeType.equalsIgnoreCase("MOUNTAIN")) {
//            MountainBikeFacotry mountainBikeFacotry = new MountainBikeFacotry();
//            HandleBars handleBars = mountainBikeFacotry.createHandlerBar();
//            Pedals pedals = mountainBikeFacotry.createPedals();
//            Tire front = mountainBikeFacotry.createTire();
//            Tire back = mountainBikeFacotry.createTire();
//            return new Bike(handleBars,pedals,front,back);
//        } else {
//            throw new IllegalArgumentException("Bike type not supported");
//        }
    }
    private static void FactoryMethodDP() {
        TicketMachine tm = new TicketMachine();
        Ticket bus = tm.createTicket("bus");
        Ticket train = tm.createTicket("train");
        System.out.println(bus.getPrice());
        System.out.println(train.getPrice());
    }

    private static void ProtoTypeDP() {
        PizzaFlavour hawaiian = new PizzaFlavour("Hawaiian");
        Pizza hawaiianPizza1 = new Pizza(4, hawaiian);
        Pizza hawaiianPizza2 = hawaiianPizza1.clone();
        Pizza hawaiianPizza3 = hawaiianPizza1.clone();
        Pizza hawaiianPizza4 = hawaiianPizza1.clone();
        Pizza hawaiianPizza5 =hawaiianPizza1.clone();
        hawaiian.setName("Hawaii with extra cheese"); // this line will update all clone object because of shallow copy

        PizzaFlavour pepperoni = new PizzaFlavour("Pepperoni");
        Pizza pepperoniPizza1 = new Pizza(5, pepperoni);
        Pizza pepperoniPizza2 = pepperoniPizza1.clone();
        Pizza pepperoniPizza3 = pepperoniPizza1.clone();
        Pizza pepperoniPizza4 = pepperoniPizza1.clone();
        Pizza pepperoniPizza5 = pepperoniPizza1.clone();

        List<Meal> order = List.of(hawaiianPizza1, hawaiianPizza2, hawaiianPizza3, hawaiianPizza4, hawaiianPizza5,
                pepperoniPizza1, pepperoniPizza2, pepperoniPizza3, pepperoniPizza4, pepperoniPizza5);
        order.stream().forEach(System.out::println);
    }

    private static void SingletonDp() {
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

    public static void BuilderDp(){
        /**
         * Now Instead of this we create using Builder DP
         *
         * Person p1 = new Person("Tracy", null,
         *                 "Westbay", LocalDate.of(1985,1,1),
         *                 "tracy@example.com",null);
         *         System.out.println(p1);
         *         Person p2 =new Person("Jerome", "Henry",
         *                 "Donaldson", null,
         *                 null, "123456789");
         *         System.out.println(p2);
         */
        Person p1 = new Person.PersonBuilder("Tushar","more")
                .setMiddleName("Tanaji").setDateOfBirth(LocalDate.of(1995,9,10))
                .setEmailAddress("emaosd@gmail.cpm").build();
        Person p2 = new Person.PersonBuilder("Dhanno","more")
                .setMiddleName("Tushar").setDateOfBirth(LocalDate.of(1997,11,4))
                .setEmailAddress("Dghagsg@gmail.cpm").build();

        System.out.println(p1);
        System.out.println(p2);

    }
}