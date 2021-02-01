package viewControllers.showObservation;

import cells.NatureObservationListCell;
import facades.NatureObservationFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import models.NatureObservation;
import mvc.ViewController;

public class ShowViewController extends ViewController {
    private NatureObservationFacade natureObservationFacade;

    public ShowViewController(NatureObservationFacade categoryFacade) {
        this.natureObservationFacade = categoryFacade;
    }

    @Override
    public void loadView() {
        ShowView showView = new ShowView();

        ObservableList<NatureObservation> items = FXCollections.observableList(natureObservationFacade.getAll());

        showView.list.setItems(items);
        showView.list.setCellFactory(new Callback<ListView<NatureObservation>, ListCell<NatureObservation>>() {
            @Override
            public ListCell<NatureObservation> call(ListView<NatureObservation> param) {
                return new NatureObservationListCell();
            }
        });

        showView.back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigationViewController.popViewController();
            }
        });
        view = showView;
    }
}
