package BehavioralDesignPattern.ObserverDP;

public class ObserverMain {
    public static void main(){
        var user1 = new UserOb();
        var user2 = new UserOb();
        var newsfeed = new NewsFeed();

        user1.addPropertyChangeListener(newsfeed);
        user2.addPropertyChangeListener(newsfeed);

        user1.setStatus("Going for a walk");
        user2.setStatus("Enjoying a coffee");

        newsfeed.printStatuses();
    }
}
