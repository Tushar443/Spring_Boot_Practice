package BehavioralDesignPattern.StateDP;

public class Auction {
    private AuctionState state;

    public Auction() {
        this.state = new AuctionClosedState();
    }

    public void startAuction() {
        state.startAuction(this);
//        if (state) {
//            System.out.println("Auction already started");
//        } else {
//            this.state = true;
//            System.out.println("Auction started");
//        }
    }

    public void closeAuction() {
        state.closeAuction(this);
//        if (!state) {
//            System.out.println("Auction already closed");
//        } else {
//            this.state = false;
//            System.out.println("Auction closed");
//        }
    }

    public void placeBid() {
        state.placeBid();
//        if (this.state) {
//            System.out.println("Bid placed");
//        } else {
//            System.out.println("Bid not placed because auction is closed");
//        }
    }

    public void setState(AuctionState state) {
        this.state = state;
    }
}
