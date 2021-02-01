package viewControllers.addLocation;

import facades.LocalisationFacade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.Localisation;
import mvc.ViewController;

public class LocationViewController extends ViewController {
    private LocalisationFacade localisationFacade;

    public LocationViewController(LocalisationFacade localisationFacade) {
        this.localisationFacade = localisationFacade;
    }

    @Override
    public void loadView() {
        LocationView locationView = new LocationView();
        locationView.back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigationViewController.popViewController();
            }
        });

        locationView.save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = locationView.name_location.getText();

                if(name == null || name.isEmpty()){
                    showAlert("Nazwa lokalizacji nie może być pusta");
                    return;
                }
                localisationFacade.add(new Localisation(name));
            }
        });
                view = locationView;
    }
}
