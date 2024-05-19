package BehavioralDesignPattern.StateDP;

public class StateDpMain {
    public static void main(){
        var auction = new Auction();
        auction.startAuction();
        auction.placeBid();

        auction.startAuction();

        auction.closeAuction();
        auction.placeBid();

        auction.closeAuction();
    }
}
