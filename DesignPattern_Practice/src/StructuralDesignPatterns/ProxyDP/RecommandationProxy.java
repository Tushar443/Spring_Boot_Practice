package StructuralDesignPatterns.ProxyDP;

public class RecommandationProxy implements Recommendation{
    private Recommendation recommendation;

    @Override
    public void showRecommendations(User user) {
        if(user.getPremium()) {
            if (recommendation == null) {
                recommendation = new SongRecommendations(user);
            }
            recommendation.showRecommendations(user);
        }else{
            System.out.println("Not a Premium member ");
        }
    }
}
