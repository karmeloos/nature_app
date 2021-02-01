package viewControllers.addObservation;

import facades.CategoryFacade;
import facades.LocalisationFacade;
import facades.NatureObservationFacade;
import helpers.ImageAdapter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.*;
import javafx.scene.image.Image;
import mvc.ViewController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.function.Consumer;

public class ObservationViewController extends ViewController{
    private NatureObservationFacade natureObservationFacade;
    private CategoryFacade categoryFacade;
    private LocalisationFacade localisationFacade;
    private File photo = null;

    public ObservationViewController(NatureObservationFacade natureObservationFacade, CategoryFacade categoryFacade, LocalisationFacade localisationFacade) {
        this.natureObservationFacade = natureObservationFacade;
        this.categoryFacade = categoryFacade;
        this.localisationFacade = localisationFacade;
    }

    @Override
    public void loadView() {
        ObservationView observationView = new ObservationView();

        List<Category> category_list = categoryFacade.getAll();
        observationView.combobox_category.setItems(FXCollections.observableList(category_list));

        List<Localisation> localisation_list = localisationFacade.getAll();
        observationView.combobox_localisation.setItems(FXCollections.observableList(localisation_list));

        observationView.photo_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigationViewController.presentImageChooser(new Consumer<File>() {
                    @Override
                    public void accept(File file) {
                        try {
                            observationView.imageView.setImage(new Image (new FileInputStream(file)));
                            photo = file;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        observationView.back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigationViewController.popViewController();
            }
        });

        observationView.save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Category selectedCategory = (Category)observationView.combobox_category.getValue();
                Localisation selectedLocalisation = (Localisation)observationView.combobox_localisation.getValue();
                String description = observationView.description_textArea.getText();
                String name = observationView.name_observation.getText();

                if (name == null || name.isEmpty()) {
                    showAlert("Wpisz nazwę");
                    return;
                }

                if (description == null || description.isEmpty()) {
                    showAlert("Wpisz opis obserwacji");
                    return;
                }

                if (selectedCategory == null) {
                    showAlert("Wybierz kategorię");
                    return;
                }

                if (selectedLocalisation == null) {
                    showAlert("Wybierz lokalizację");
                    return;
                }

                if (photo == null) {
                    showAlert("Wybierz zdjecie");
                    return;
                }

                NatureObservation model = new NatureObservation(name, selectedCategory, selectedLocalisation, description,  new ImageAdapter(photo));
                natureObservationFacade.add(model);
            }
        });

        view = observationView;
    }
}
