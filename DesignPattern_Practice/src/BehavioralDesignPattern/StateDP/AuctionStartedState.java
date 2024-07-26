package BehavioralDesignPattern.StateDP;

public class AuctionStartedState implements AuctionState{
    @Override
    public void startAuction(Auction auction) {
        System.out.println("Auction Already Started");
    }

    @Override
    public void closeAuction(Auction auction) {
        auction.setState(new AuctionClosedState());
        System.out.println("Auction Closed");
    }

    @Override
    public void placeBid() {
        System.out.println("Bid Placed");
    }
}
