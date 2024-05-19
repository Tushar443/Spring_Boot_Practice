package BehavioralDesignPattern.StateDP;

public class AuctionClosedState implements AuctionState{
    @Override
    public void startAuction(Auction auction) {
        auction.setState(new AuctionStartedState());
        System.out.println("Auction Started");
    }

    @Override
    public void closeAuction(Auction auction) {
        System.out.println("Auction Closed");
    }

    @Override
    public void placeBid() {
        System.out.println("Bid not Placed because Auction is closed");
    }
}
