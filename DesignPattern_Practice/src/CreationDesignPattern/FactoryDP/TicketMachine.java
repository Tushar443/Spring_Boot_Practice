package CreationDesignPattern.FactoryDP;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TicketMachine {
    public static final Map<String, Supplier<Ticket>> map = new HashMap<>();

    static {
        map.put("bus",()->new BusTicket()); //  map.put("Bus",BusTicket::new);
        map.put("train",TrainTicket::new);
    }
    public Ticket createTicket(String type) {
        if(map.get(type) != null){
            return map.get(type).get();
        }else {
            throw new IllegalArgumentException("Invalid Ticket ");
        }


    }

}
