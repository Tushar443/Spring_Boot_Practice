package StructuralDesignPatterns.ProxyDP;

public class ProxyMain {

    private static final RecommandationProxy recommandationProxy = new RecommandationProxy();

    public static void main(){
        User user = new User("Jill",false);
        loadHomePage(user);
        loadDiscoverPage(user);
    }

    private static void loadHomePage(User user) {
        System.out.println("Loading home page...");
        recommandationProxy.showRecommendations(user);
    }

    private static void loadDiscoverPage(User user) {
        System.out.println("Loading discover page...");
        recommandationProxy.showRecommendations(user);
    }
}
