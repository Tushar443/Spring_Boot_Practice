package BehavioralDesignPattern.StateDP;

public interface AuctionState {

    void startAuction(Auction auction);
    void closeAuction(Auction auction);
    void placeBid();
}
