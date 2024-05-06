import CreationDesignPattern.BuilderDP.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /**
         * Builder Design Pattern
         */
        BuilderDp();
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