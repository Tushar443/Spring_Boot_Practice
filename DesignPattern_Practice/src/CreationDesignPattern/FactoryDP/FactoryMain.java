package CreationDesignPattern.FactoryDP;

public class FactoryMain {
    public static void main(){
        TicketMachine tm = new TicketMachine();
        Ticket bus = tm.createTicket("bus");
        Ticket train = tm.createTicket("train");
        System.out.println(bus.getPrice());
        System.out.println(train.getPrice());
    }
}
