import factories.ViewControllerFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import mvc.NavigationViewController;
import mvc.ViewController;

public class MainController extends Application {
    @Override
    public void start(Stage stage) {
        ViewControllerFactory viewControllerFactory = new ViewControllerFactory();
        ViewController menuViewController = viewControllerFactory.makeMenuViewController();

        new NavigationViewController(menuViewController, stage, viewControllerFactory);
        stage.setTitle("Nature_APP");
        stage.show();
    }
    public void appStart() {
        launch();
    }
}