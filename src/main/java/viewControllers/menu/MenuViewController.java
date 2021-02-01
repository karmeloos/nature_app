package viewControllers.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mvc.ViewController;

public class MenuViewController extends ViewController {

    @Override
    public void loadView() {
        MenuView menuView = new MenuView();

        menuView.add_localization_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewController viewController = navigationViewController.viewControllerFactory.makeLocationViewController();
                navigationViewController.pushViewController(viewController);
            }
        });

        menuView.add_observation_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                ViewController viewController = navigationViewController.viewControllerFactory.makeObservationViewController();
                navigationViewController.pushViewController(viewController);
            }
        });

        menuView.add_category_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event2) {
                ViewController viewController = navigationViewController.viewControllerFactory.makeCategoryViewController();
                navigationViewController.pushViewController(viewController);
            }
        });

        menuView.view_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event3) {
                ViewController viewController = navigationViewController.viewControllerFactory.makeShowViewController();
                navigationViewController.pushViewController(viewController);
            }
        });

        view = menuView;
    }
}
